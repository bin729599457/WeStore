package com.westore.service.service.impl;

import com.westore.dao.OrderDAO;
import com.westore.model.T_B_Order;
import com.westore.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDAO orderDAO;

    public List<Map<String, Object>> findOrders(Map<String, Object> paraMap) {

        return orderDAO.findOrders(paraMap);
    }

    public void addOrder(Map<String, Object> paraMap) {

        orderDAO.addOrder(paraMap);
    }

    public void delOrder(Map<String, Object> paraMap) {
        orderDAO.deleteOrder(paraMap);
    }

    public void updateOrder(Map<String, Object> paraMap) {
        orderDAO.updateOrder(paraMap);
    }

}
