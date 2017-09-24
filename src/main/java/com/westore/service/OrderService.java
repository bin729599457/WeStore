package com.westore.service;

import com.westore.model.T_B_Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    public List<T_B_Order> findOrders(Map<String, Object> paraMap);

    public void addOrder(Map<String, Object> paraMap);

    public void delOrder(Map<String, Object> paraMap);

    public void updateOrder(Map<String, Object> paraMap);

}
