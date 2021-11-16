package springbootdatajdbc.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    @RequestMapping(value = "hello1233")
    public String test1(@RequestParam("name") String name){
        return "你好";

    }
}
