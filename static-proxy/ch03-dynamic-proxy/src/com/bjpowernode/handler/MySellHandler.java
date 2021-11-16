package com.bjpowernode.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MySellHandler implements InvocationHandler {
   private Object targect = null;
    public  MySellHandler(Object targect){
       this.targect=targect;
   }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      //向厂家发送订单，告诉厂家，我买优盘了厂家发货
       // float price = factory.sell(mount);
        Object res = null;
        res = method.invoke(targect,args);
        System.out.println(res);
        if(res!=null){
            float frice = (Float)res;
            frice=frice+25;
            res=frice;
        }
        return res;
    }
}
