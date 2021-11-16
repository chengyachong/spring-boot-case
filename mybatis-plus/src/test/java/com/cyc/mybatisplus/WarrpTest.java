package com.cyc.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cyc.mybatisplus.mapper.UserMapper;
import com.cyc.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WarrpTest {
    @Autowired
    private UserMapper userMapper;
    @Test
     void conxtTest(){
       QueryWrapper<User> wa =   new QueryWrapper();
       wa.isNotNull("name").isNotNull("email").ge("age",12);
        userMapper.selectList(wa);
    }
}
