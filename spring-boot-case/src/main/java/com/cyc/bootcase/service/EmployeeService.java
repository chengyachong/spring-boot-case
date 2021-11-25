package com.cyc.bootcase.service;

import com.cyc.bootcase.bean.Employee;
import com.cyc.bootcase.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的返回结果保存在缓存中
     * 以后再要相同的数据 直接从缓存中获取不用再调用方法了
     * 几个属性：
     *    cacheNames/value 执行缓存的名字
     *    key 要缓存数据使用的key 可以用他来指定，默认使用方法参数的值，方法的返回值 编写spel
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmployee(Integer id){
        System.out.println("查询"+id);
       return  employeeMapper.getEmpById(id);
    }
}
