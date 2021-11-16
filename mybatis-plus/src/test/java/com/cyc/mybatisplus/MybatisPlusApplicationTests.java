package com.cyc.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyc.mybatisplus.mapper.UserMapper;
import com.cyc.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
 private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> list = userMapper.selectList(null);
         list.forEach(System.out::println);
    }
    @Test
    void InsertTest(){
       User user = new User();
       user.setAge(10);
       user.setEmail("111");
       user.setName("程亚崇");
      int result =  userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);
    }
    @Test
    void updateTest(){
        User user = new User();
        user.setId(5L);
        user.setName("我最帅1");
      userMapper.updateById(user);
    }
    //测试乐观锁成功操作
     @Test
    public void testOptimisticLocker(){

       User user =  userMapper.selectById(1L);
       user.setName("cyc");
       user.setEmail("18300560411");
       userMapper.updateById(user);

    }
//测试查询一条数据
    @Test
    public void  testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }
//测试批量查询
    @Test
    public  void testSelectBatchId(){
        List <User> user =userMapper.selectBatchIds(Arrays.asList(1,2,3));
        user.forEach(System.out::println);
    }
    //测试条件查询按map查询
    @Test
    public void testSelectByBatchIds(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","cyc");
       List<User> u = userMapper.selectByMap(map);
       u.forEach(System.out::println);

    }
    //测试分页查询
    @Test
    public void testPage(){
        Page<User> page =new Page<>(2,5);
       userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
    }
    //删除测试
    @Test
    public void testDelete(){
        userMapper.deleteById(1L);
    }
}
