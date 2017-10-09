package com.westore.service;

import com.westore.model.T_B_Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    public List<Map<String, Object>> findOrders(Map<String, Object> paraMap);

    public void addOrder(Map<String, Object> paraMap);

    public void delOrder(Map<String, Object> paraMap);

    public void updateOrder(Map<String, Object> paraMap);

    public List<Map<String, Object>> getOrdersDetail(Map<String, Object> paraMap);

}
