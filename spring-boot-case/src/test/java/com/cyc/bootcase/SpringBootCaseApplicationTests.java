package com.cyc.bootcase;

import com.cyc.bootcase.bean.Employee;
import com.cyc.bootcase.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootCaseApplicationTests {
    @Autowired
     EmployeeMapper employeeMapper;
    @Test
    void contextLoads() {
      Employee employee =  employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

}
