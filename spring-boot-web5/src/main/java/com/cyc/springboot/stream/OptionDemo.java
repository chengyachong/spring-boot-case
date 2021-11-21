package com.cyc.springboot.stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionDemo {
    public static void main(String[] args) {
// 先根据name分组，然后根据age(成年和未成年)分组
Map<String,Map<Object,List<Person>>> map = Stream.of( new Person("张三", 18, 175) ,
        new Person("李四", 22, 177)
        , new Person("张三", 14, 165) ,
        new Person("李四", 15, 166) ,
        new Person("张三", 19, 182) ).collect(Collectors.groupingBy( Person::getName ,
        Collectors.groupingBy(p->p.getAge()>=18?"成年":"未成年" ) )); map.forEach((k,v)->{ System.out.println(k); v.forEach((k1,v1)->{ System.out.println("\t"+k1 + "=" + v1); }); });
        Map<String, List<Person>> map1 = Stream.of( new Person("张三", 18, 175) ,
                new Person("李四", 22, 177) ,
                new Person("张三", 14, 165) ,
                new Person("李四", 15, 166) ,
                new Person("张三", 19, 182) )
                .collect(Collectors.groupingBy(Person::getName));
        map1.forEach((k, v)-> System.out.println("k=" + k +"\t"+ "v=" + v));
        System.out.println("-----------"); // 根据年龄分组 如果大于等于18 成年否则未成年
        Map<String, List<Person>> map2 = Stream.of( new Person("张三", 18, 175) ,
                new Person("李四", 22, 177) ,
                new Person("张三", 14, 165) ,
                new Person("李四", 15, 166) ,
                new Person("张三", 19, 182) ).collect(Collectors.groupingBy(p -> p.getAge() >= 18 ? "成年" : "未成 年"));
        map2.forEach((k,v)-> System.out.println("k=" + k +"\t"+ "v=" + v));
        Optional<String> op1 = Optional.of("张三");
        Optional<String> op2 = Optional.empty();
        if (op1.isPresent()){
            System.out.println(op1.get());
        }
        if (op2.isPresent()){
            System.out.println(op2.get());
        }else{
            System.out.println("op2是一个空对象");
        }
        String s3 = op1.orElse("李四");
        System.out.println(s3);
        String s48= op1.orElse("李四");
        System.out.println(s48);
        String s4 = op2.orElse("王五");
        System.out.println(s4);
        String s5 = op2.orElseGet(()->{ return "Hello"; }); System.out.println(s5);
    }
}
