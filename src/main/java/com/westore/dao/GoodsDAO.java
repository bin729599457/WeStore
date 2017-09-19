package com.westore.dao;

import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Location;
import com.westore.model.T_B_Order;

import java.util.List;

public interface GoodsDAO {

    //商品操作
    public List<T_B_Goods> findAll();

    public List<T_B_Goods> findByName();

    public List<T_B_Goods> findById();



}
