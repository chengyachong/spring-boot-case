package com.cyc.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Value("${JAVA_HOME}")
    private String mavenHome;

    @GetMapping("car/{id}/owner/{zs}")
    public Map<String,Object> getCar(@PathVariable Integer id, @PathVariable("zs")String name,
                                     @PathVariable Map<String,String> map1,
                                     @RequestHeader Map<String,String > header){
        Map<String ,Object> map = new HashMap<>();
      //  map.put("id",id);
        //map.put("zs",name);
       // map.put("map1",map1);
map.put("header",header);
       // map.put("_ga",ga);
      return map;
    }
@GetMapping("/getjavamsg")
    private String getMavenHome(){
        return mavenHome;
    }
}
