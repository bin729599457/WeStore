package com.westore.dao;

import com.westore.model.T_B_Location;

import java.util.List;

public interface LocationDAO {

        //地址操作
        public List<T_B_Location> findAll();

}
