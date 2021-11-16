package com.dfe.service;


import com.dfe.model.Student;
import org.springframework.stereotype.Component;
import javax.jws.WebService;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @date 2019/01/30
 */
@WebService(serviceName = "StudentService",
        targetNamespace = "http://service.simple.cfx.com",
        endpointInterface = "com.dfe.service.StudentService")
@Component
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudentList() {
        Student stu1 = new Student("学生1",25);
        Student stu2 = new Student("学生2",30);
        return Arrays.asList(stu1,stu2);
    }
}