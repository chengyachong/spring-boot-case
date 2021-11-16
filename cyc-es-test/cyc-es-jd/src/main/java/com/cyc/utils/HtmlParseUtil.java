package com.cyc.utils;

import com.cyc.pojo.Goods;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {
    public static List<Goods> getTargetGoods(String keywords) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keywords;
        Document document = Jsoup.parse(new URL(url), 3000);
        Element list = document.getElementById("J_goodsList");
        //System.out.println(list.html());
        Elements li = list.getElementsByTag("li");
        List<Goods> goodsArrayList = new ArrayList<>();
        for (Element element : li) {
            String img = element.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String name = element.getElementsByClass("p-name").eq(0).text();
            String price = element.getElementsByClass("p-price").eq(0).text();
            Goods goods = new Goods();
            goods.setImg(img);
            goods.setName(name);
            goods.setPrice(price);
            System.out.println(img);
            goodsArrayList.add(goods);
        }
        return goodsArrayList;
    }


}
