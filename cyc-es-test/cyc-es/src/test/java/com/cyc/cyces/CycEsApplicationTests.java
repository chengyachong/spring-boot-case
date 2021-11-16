package com.cyc.cyces;

import com.alibaba.fastjson.JSON;
import com.cyc.cyces.pojo.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class CycEsApplicationTests {
    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;
    //创建索引
    @Test
    void testCreateIndex() throws IOException {
        //1. 创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("kuang_index");
        //2. 客户端执行创建请求 IndicesClient 请求后获得响应
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);

        System.out.println(createIndexResponse);
    }
    //判断索引是否存在
    @Test
    void testExists() throws IOException {
        GetIndexRequest request = new GetIndexRequest("kuang_index");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }
//删除索引
    @Test
void testDeleteIndex() throws IOException {
    DeleteIndexRequest request = new DeleteIndexRequest("test1");
    //删除
    AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
    System.out.println(delete.isAcknowledged());
}

//测试添加文档
    @Test
    void testAddDocumnet() throws IOException {
        //创建对象
        User user = new User("程蚜虫",21);
        //创建请求
        IndexRequest request = new IndexRequest("kuang_index");
        //规则 put/kuang_index/_doc/1
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        //请求放入json
        request.source(JSON.toJSONString(user), XContentType.JSON);
        //用客户端发送请求
       IndexResponse ii = client.index(request,RequestOptions.DEFAULT);
       System.out.println(ii.toString());
    }
//获取文档 判断是否存在
    @Test
    void testIsExits() throws IOException {
        GetRequest getRequest = new GetRequest("kuang_index","1");
        //不获取返回_source的上下文
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");
        boolean exists = client.exists(getRequest,RequestOptions.DEFAULT);
        System.out.println(exists);
    }
    //获取文档信息
    @Test
    void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest("kuang_index","1");
        //不获取返回_source的上下文
        GetResponse getResponse = client.get(getRequest,RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString());
    }
    //更新文档
    @Test
    void  testUpdate() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("kuang_index","1");
        updateRequest.timeout("1s");
        User user = new User("程亚崇真帅",12);
        updateRequest.doc(JSON.toJSONString(user),XContentType.JSON);
        UpdateResponse updateResponse =client.update(updateRequest,RequestOptions.DEFAULT);
        System.out.println(updateResponse.status());
    }
    //删除文档
    @Test
    void testDelete() throws  IOException{
        DeleteRequest request = new DeleteRequest("kuang_index","1");
        request.timeout("1s");
        DeleteResponse deleteResponse = client.delete(request,RequestOptions.DEFAULT);
        System.out.println(deleteResponse.status());
    }
    //批量插入数据
    @Test
    void testBulkRequest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        List<User> list = new ArrayList<>();
        list.add(new User("chen1", 3));
        list.add(new User("chen2", 3));
        list.add(new User("chen3", 3));
        list.add(new User("chen4", 3));
        list.add(new User("chen5", 3));
        list.add(new User("chen6", 3));

        //批处理请求
        for (int i = 0; i < list.size(); i++) {
            // 批量更新和批量删除，就在这里修改对应请求就可以了
            bulkRequest.add(new IndexRequest("kuang_index")
                    .id("" + (i + 1))
                    .source(JSON.toJSONString(list.get(i)), XContentType.JSON)
            );
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        //是否失败 ，返回 false 表示成功
        System.out.println(bulkResponse.hasFailures());

    }
//查询
    @Test
void testSearch() throws IOException {
    SearchRequest searchRequest = new SearchRequest("kuang_index");
    //构建搜索的条件
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    //查询条件，我们可以使用QueryBuilders工具类来实现
    //QueryBuilders.termQuery 精确
    //QueryBuilders.matchAllQuery() 匹配所有
    TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "chen1");
    sourceBuilder.query(termQueryBuilder);
    sourceBuilder.from(1);
    sourceBuilder.size(2);
    sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

    searchRequest.source(sourceBuilder);

    SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
    System.out.println(JSON.toJSONString(searchResponse.getHits()));
    for (SearchHit searchHit : searchResponse.getHits().getHits()) {
        System.out.println(searchHit.getSourceAsMap());
    }
}
}
