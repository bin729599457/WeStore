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

    public List<T_B_Order> findAllOrders() {
        return orderDAO.findAll();
    }

    public List<T_B_Order> findOrderById(Map<String, Object> paraMap) {
        return orderDAO.findById(paraMap);
    }


}
