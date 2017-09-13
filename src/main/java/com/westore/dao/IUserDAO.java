package com.westore.dao;


import com.westore.model.User;

import java.util.List;

public interface IUserDAO {

    public List<User> findAll();

}
