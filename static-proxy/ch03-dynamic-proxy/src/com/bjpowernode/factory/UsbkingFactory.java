package com.bjpowernode.factory;

import com.bjpowernode.service.UsbSell;

public class UsbkingFactory implements UsbSell {
    @Override
    public float sell(int amount) {
        //目标方法
        System.out.println("目标类中，执行sell方法");
        return 85.0f;
    }
}
