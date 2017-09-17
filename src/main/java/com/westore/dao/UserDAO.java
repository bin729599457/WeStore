package com.westore.dao;


import com.westore.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

}
