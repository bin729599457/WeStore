package com.westore.dao;

import com.westore.model.T_B_Order;

import java.util.List;
import java.util.Map;

public interface OrderDAO {

    //订单操作
    public List<T_B_Order> findAll();

    public List<T_B_Order> findByName(Map<String, Object> paraMap);

    public List<T_B_Order> findById(Map<String, Object> paraMap);
}
