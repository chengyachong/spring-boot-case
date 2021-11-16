package com.cyc.service;

import com.cyc.service.com.cyc.shangjia.Taobao;

public class ShopMain {
    public static void main(String[] args) {
        //创建代理的商家taobao对象
        Taobao taobao = new Taobao();
        float price = taobao.sell(85);
        System.out.println("售价："+price);
    }
}
