package com.bjpowernode;

import com.bjpowernode.factory.UsbkingFactory;
import com.bjpowernode.handler.MySellHandler;
import com.bjpowernode.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainShop {
    public static void main(String[] args) {
        UsbSell factory = new UsbkingFactory();
        //创建invocationHandler对象
        InvocationHandler handler = new MySellHandler(factory);
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(),factory.getClass().getInterfaces(),handler);
        float price =proxy.sell(1);
        System.out.println("通过动态代理对象调用方法"+price);
    }
}
