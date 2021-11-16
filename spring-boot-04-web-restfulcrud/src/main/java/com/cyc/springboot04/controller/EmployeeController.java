package com.cyc.springboot04.controller;

import com.cyc.springboot04.dao.DepartmentDao;
import com.cyc.springboot04.dao.EmployeeDao;
import com.cyc.springboot04.entities.Department;
import com.cyc.springboot04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
   public EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工返回列表页面
    @GetMapping("emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping("emp")
    public String toAddPage(Model model){
        //来到添加页面，查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        System.out.println("保存员工信息"+employee);
        employeeDao.save(employee);
        //redirect:表示重定向到一个地址
        //forward :表示转发到一个地址
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public  String toEditPage(@PathVariable("id") Integer id,Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        Employee employee = employeeDao.get(id);
        model.addAttribute("depts",departments);
        model.addAttribute("emp",employee);
        return "emp/add";
    }
    //员工修改
    @PutMapping("/emp")
    public  String updateEmployee(Employee employee){
        System.out.println("修改员工数据"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
