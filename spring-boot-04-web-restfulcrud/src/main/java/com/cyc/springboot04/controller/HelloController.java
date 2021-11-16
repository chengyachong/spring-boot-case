package com.cyc.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping({"/","/login.html"})
    public String index(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "helloWorld";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
