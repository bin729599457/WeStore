package com.westore.service;

import com.westore.dao.IUserDAO;
import com.westore.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements IUserService{

    @Resource
    private IUserDAO userDAO;

    public List<User> findAllUser(){
            return this.userDAO.findAll();
    }
}
