package com.westore.service;

import com.westore.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAllUser();

    public String Login(String code);

    public String checkLogin(String trd_session);

    public String change(String trd_session,String method,String value);


}
