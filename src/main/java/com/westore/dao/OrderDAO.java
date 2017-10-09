package com.westore.dao;

import com.westore.model.T_B_Order;

import java.util.List;
import java.util.Map;

public interface OrderDAO {

    //订单操作
    public List<Map<String, Object>> findOrders(Map<String, Object> paraMap);

    public void addOrder(Map<String, Object> paraMap);

    public void deleteOrder(Map<String, Object> paraMap);

    public void updateOrder(Map<String, Object> paraMap);

    public List<Map<String, Object>> getOrdersDetail(Map<String, Object> paraMap);

    public List<Map<String, Object>> getGoodsDetail(Map<String, Object> paraMap);


}
