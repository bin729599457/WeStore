package com.westore.dao;


import com.westore.model.T_B_User;
import com.westore.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    public String ifExist(String openid);

    public void insertUser(T_B_User user);

    public void updateUser(T_B_User user);

}
