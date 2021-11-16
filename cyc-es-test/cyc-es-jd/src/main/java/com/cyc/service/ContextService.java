package com.cyc.service;

import com.alibaba.fastjson.JSON;
import com.cyc.pojo.Goods;
import com.cyc.utils.HtmlParseUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ContextService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    //1.解析数据放入到es索引中去
    public Boolean parseContent(String keywords) throws Exception{
      List<Goods> list= HtmlParseUtil.getTargetGoods(keywords);
      //把查询到的数据批量插入到es中
        BulkRequest request = new BulkRequest();
        request.timeout("2s");
        for (int i=0;i<list.size();i++){
            request.add(new IndexRequest("jd_goods").source(JSON.toJSONString(list.get(i)), XContentType.JSON));
        }
        BulkResponse bulkItemResponses = restHighLevelClient.bulk(request,RequestOptions.DEFAULT);
       return !bulkItemResponses.hasFailures();
    }

    public Boolean BulkGoods(String keywords) throws IOException {
        List<Goods> goodsList = HtmlParseUtil.getTargetGoods(keywords);
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        for (int i = 0; i < goodsList.size(); i++) {
            bulkRequest.add(new IndexRequest("jd_goods").source(JSON.toJSONString(goodsList.get(i)), XContentType.JSON));
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulk.hasFailures();
    }

    public List<Map<String, Object>> SearchGoods(String keywords, int pageNum, int pageSize) throws Exception{
        if (pageNum<=0){
            pageNum=1;
        }
        SearchRequest jd_goods = new SearchRequest("jd_goods");
        //构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        HighlightBuilder highlightBuilder = new HighlightBuilder();

        highlightBuilder.field("name");
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        searchSourceBuilder.highlighter(highlightBuilder);

        searchSourceBuilder.from(pageNum);
        searchSourceBuilder.size(pageSize);
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("name", keywords);
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        jd_goods.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(jd_goods, RequestOptions.DEFAULT);
        ArrayList<Map<String, Object>> goodlist = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {

            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField name = highlightFields.get("name");
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
           //解析高亮字段，将原来的字段换成高亮字段即可
            if (name!=null){
                Text[] fragments = name.fragments();
                String title="";
                for (Text fragment : fragments) {
                    title+=fragment;
                }
                sourceAsMap.put("name",title);//替换调原来字段即可
            }
            goodlist.add(sourceAsMap);

        }
        return goodlist;
    }
}
