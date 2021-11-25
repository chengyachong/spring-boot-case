package com.cyc.bootcase.mapper;

import com.cyc.bootcase.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id =#{id}")
    public Employee getEmpById(Integer id);
    @Update("update employee set lastName = #{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id =#{id}")
     public void updateEmp(Employee employee);
    @Delete("delete from employee where id = #{id}")
    public  void  delete(Integer id);
    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public  void insertEmployee(Employee employee);
}
