package com.service.impl;

import com.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("say hello"+name);
    }
}
