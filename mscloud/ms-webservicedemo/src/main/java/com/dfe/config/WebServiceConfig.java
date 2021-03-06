package com.dfe.config;

import com.dfe.service.StudentService;
import com.dfe.service.UserService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author Administrator
 * @date 2019/01/30
 */
@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    @Bean
    public Endpoint endpointUserService() {
        EndpointImpl endpoint = new EndpointImpl(bus,userService);
        endpoint.publish("/                     ");//接口发布在 /UserService 目录下
        return endpoint;
    }

    @Bean
    public Endpoint endpointStudentService() {
        EndpointImpl endpoint = new EndpointImpl(bus,studentService);
        endpoint.publish("/StudentService");//接口发布在 /StudentService 目录下
        return endpoint;
    }
}