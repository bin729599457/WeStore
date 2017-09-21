package com.westore.controller;

import com.westore.model.AjaxJSON;
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
    @RequestMapping(value="/getOrders.do",produces="application/json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJSON getOrders(HttpServletRequest request){
        AjaxJSON j=new AjaxJSON();

        try {

            Map<String, Object> paraMap=new HashMap<String, Object>();
            String id=request.getParameter("id") == null? "": request.getParameter("id");
            String user_id=request.getParameter("user_id") == null? "": request.getParameter("user_id");
            String order_date=request.getParameter("order_date") == null? "": request.getParameter("order_date");

            paraMap.put("id",id);
            paraMap.put("user_id",user_id);
            paraMap.put("order_date",order_date);
            List<T_B_Order> ordersList=orderService.findOrders(paraMap);
            j.setObj(ordersList);
            j.setMsg("查询订单列表成功");

        }catch (Exception e){
            j.setMsg(""+e.getMessage());
            j.setSuccess(false);
            return j;
        }


        return j;
    }
}
