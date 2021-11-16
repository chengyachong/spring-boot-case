package com.cyc.controller;

import com.cyc.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private ContextService contextService;
    @GetMapping({"/","index"})
    public String index(){
        return "index";
    }
    @GetMapping("/parse/{keyword}")
    @ResponseBody
    public  Boolean parse(@PathVariable("keyword") String keyword) throws  Exception{
        return contextService.BulkGoods(keyword);
    }
    @GetMapping("/search/{keyword}/{pageNum}/{pageSize}")
    @ResponseBody
    public List<Map<String, Object>> SearchGoods(
            @PathVariable("keyword") String keyword,
            @PathVariable("pageNum") int pageNum,
            @PathVariable("pageSize") int pageSize
    ) throws Exception {
        return contextService.SearchGoods(keyword,pageNum,pageSize);
    }
}
