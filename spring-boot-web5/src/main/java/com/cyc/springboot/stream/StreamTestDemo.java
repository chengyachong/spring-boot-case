package com.cyc.springboot.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTestDemo {
    /*** 1. 第一个队伍只保留姓名长度为3的成员 *
     * 2. 第一个队伍筛选之后只要前3个人 *
     *  3. 第二个队伍只要姓张的成员 *
     *  4. 第二个队伍筛选之后不要前两个人 *
     *  5. 将两个队伍合并为一个队伍 *
     *  6. 根据姓名创建Person对象
     输出结果：
     5.Stream结果收集
     5.1 结果收集到集合中
     * 7. 打印整个队伍的Person信息 * @param args */
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子", "洪七 公");
        List<String> list2 = Arrays.asList("古力娜扎", "张无忌", "张三丰", "赵丽颖", "张二狗", "张天爱", "张三");
     //   1. 第一个队伍只保留姓名长度为3的成员 *
    // * 2. 第一个队伍筛选之后只要前3个人 *
       // list1.stream().filter(p->p.length()==3).limit(1).forEach(System.out::println);
          //*  3. 第二个队伍只要姓张的成员 *
          // *  4. 第二个队伍筛选之后不要前两个人 *
      //  list2.stream().filter(p->p.startsWith("张")).skip(2).forEach(System.out::println);
      //  *  5. 将两个队伍合并为一个队伍 *
     //*  6. 根据姓名创建Person对象
        Stream.concat( list1.stream(),list2.stream()).map(Person::new).forEach(System.out::println);
    }
}
