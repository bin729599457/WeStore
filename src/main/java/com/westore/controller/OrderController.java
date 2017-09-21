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
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/OrderController")
public class OrderController {

    @Resource
    private OrderService orderService;
//produces="application/json" 功能处理方法将产生json格式数据
    @RequestMapping(value="/getOrders.do",method = RequestMethod.POST)
    @ResponseBody
    public JSONArray getOrders(HttpServletRequest request){

        Map<String, Object> paraMap=new HashMap<String, Object>();
        String id=request.getParameter("id") == null? "": request.getParameter("id");
        String user_id=request.getParameter("user_id") == null? "": request.getParameter("user_id");
        String order_date=request.getParameter("order_date") == null? "": request.getParameter("order_date");
        paraMap.put("id","sda");
        paraMap.put("user_id",user_id);
        paraMap.put("order_date",order_date);

        List<T_B_Order> ordersList=orderService.findOrders(paraMap);
        JSONArray ordersListJSON = new JSONArray();
        for(T_B_Order item:ordersList){
            JSONObject order = new JSONObject();
            order.put("id",item.getId());
            order.put("user_id",item.getUser_id());
            order.put("total_money",item.getTotal_money());
            order.put("order_date",item.getOrder_date().toString());
            order.put("order_state",item.getOrder_state());

            ordersListJSON.add(order);
        }

        return ordersListJSON;
    }
}
