package com.westore.dao;

import com.westore.model.T_B_Order;

import java.util.List;
import java.util.Map;

public interface OrderDAO {

    //订单操作
    public List<T_B_Order> findOrders(Map<String, Object> paraMap);

    public void addOrder(Map<String, Object> paraMap);

    public void deleteOrder(Map<String, Object> paraMap);

    public void updateOrder(Map<String, Object> paraMap);
}
