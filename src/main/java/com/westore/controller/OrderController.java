package com.westore.controller;

import com.westore.model.T_B_Order;
import com.westore.service.OrderService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/OrderController")
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value="/getAllOrders.do",produces="text/html;charset=UTF-8" ,method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllOrders(){

//        JSONArray ordersListJSON = new JSONArray();
        Map<String,Object> paraMap=new HashMap<String, Object>();
        List<T_B_Order> ordersList=orderService.findAllOrders();
//        for(T_B_Order item:ordersList){
//            JSONObject order = new JSONObject();
//            order.put("id",item.getId());
//            order.put("user_id",item.getUser_id());
//            order.put("total_money",item.getTotal_money());
//            order.put("order_date",item.getOrder_date());
//            order.put("order_state",item.getOrder_state());
//
//            ordersListJSON.add(order);
//        }
        paraMap.put("ordersList",ordersList);

        return paraMap;
    }
}
