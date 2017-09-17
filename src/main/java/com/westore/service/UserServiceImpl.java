package com.westore.service;

import com.westore.dao.UserDAO;
import com.westore.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    public List<User> findAllUser(){
            return this.userDAO.findAll();
    }
}
