package com.dfe.service;

import com.dfe.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * @author Administrator
 * @date 2019/01/30
 */
@WebService(targetNamespace = "http://service.simple.cfx.com")// 命名空间，写一个有意义的http地址就行，并不是网上所说的要写成包名倒序,只不过写成包名倒序易读而已
public interface UserService {

    @WebMethod
    List<User> getUserList(@WebParam(name = "userName") String userName);
}