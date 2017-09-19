package com.westore.service;

import com.westore.model.T_B_Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    public List<T_B_Order> findAllOrders();

    public List<T_B_Order> findOrderById(Map<String, Object> paraMap);

}
