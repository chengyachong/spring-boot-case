package com.cyc.service.com.cyc.shangjia;

import com.cyc.service.UsbKingFactory;
import com.cyc.service.UsbSell;

public class Taobao implements UsbSell {
    private UsbKingFactory factory = new UsbKingFactory();
    @Override
    public float sell(int amount) {
        //向厂家发送订单，告诉厂家，我买了优盘，厂家发货
        float price = factory.sell(amount);
        price =price+25;
        System.out.println("淘宝商家返回一个优惠券，或者红包");
        return price;
    }
}
