package com.westore.controller;

import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Order;
import com.westore.model.T_B_Order_Detail;
import com.westore.service.*;
import com.westore.service.service.impl.CommomServiceImpl;
import com.westore.utils.CustomUUID;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/OrderController")
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private CommomService commomService;

    @RequestMapping(value = "/getOrders.do")
    @ResponseBody
    public AjaxJSON getOrders(HttpServletRequest request) {
        AjaxJSON j = new AjaxJSON();

        try {

            Map<String, Object> paraMap = new HashMap<String, Object>();
            String id = request.getParameter("id") == null ? "" : request.getParameter("id");
            String user_id = request.getParameter("user_id") == null ? "" : request.getParameter("user_id");
            String order_date = request.getParameter("order_date") == null ? "" : request.getParameter("order_date");

            paraMap.put("id", id);
            paraMap.put("user_id", user_id);
            paraMap.put("order_date", order_date);
            List<T_B_Order> ordersList = orderService.findOrders(paraMap);
            j.setObj(ordersList);
            j.setMsg("查询订单列表成功");

        } catch (Exception e) {
            j.setMsg("" + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }

    @RequestMapping(value = "/addOrder.do")
    @ResponseBody
    public AjaxJSON addOrder(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON obj){
        AjaxJSON j=new AjaxJSON();

        try {

            String user_id= (String) params.get("user_id");

            if(user_id==null&&user_id.equals("")){
                j.setMsg("user_id为空");
                j.setSuccess(false);
                return j;
            }
            //获得商品详情列表
            List t_b_order_detail_list= (List) JSONArray.fromObject(obj.getObj());


            T_B_Order t_b_order=new T_B_Order();
            t_b_order.setId(CustomUUID.getFlowIdWorkerInstance().generate());
            t_b_order.setOrder_date(new Date());
            t_b_order.setOrder_state(0);

            commomService.add(t_b_order);
            j.setObj(t_b_order);
            j.setMsg(" 订单生成成功");


        }catch (Exception e){
            j.setMsg(e.getMessage());
        }
        return j;
    }


    @RequestMapping(value = "/deleteOrder.do")
    @ResponseBody
    public AjaxJSON deleteOrder(HttpServletRequest request){
        AjaxJSON j=new AjaxJSON();

        try {

            String order_id = request.getParameter("order_id") == null ? "" : request.getParameter("order_id");

            if(order_id==null&&order_id.equals("")){
                j.setMsg("id为空");
                j.setSuccess(false);
                return j;
            }

            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put("id", order_id);

            orderService.delOrder(paraMap);

        }catch (Exception e){
            j.setMsg(e.getMessage());
        }
        return j;
    }

    @RequestMapping(value = "/updateOrder.do")
    @ResponseBody
    public AjaxJSON updateOrder(HttpServletRequest request){
        AjaxJSON j=new AjaxJSON();

        try {

            String order_id = request.getParameter("order_id");
            String total_money = request.getParameter("total_money") == null ? "" : request.getParameter("total_money");
            String order_date = request.getParameter("order_date") == null ? "" : request.getParameter("order_date");
            String order_state = request.getParameter("order_state") == null ? "" : request.getParameter("order_state");

            if(order_id==null&&order_id.equals("")){
                j.setSuccess(false);
                j.setMsg("id为空");
                return j;
            }

            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put("id", order_id);
            paraMap.put("total_money",total_money);
            paraMap.put("order_date",order_date);
            paraMap.put("order_state",order_state);

            orderService.updateOrder(paraMap);

        }catch (Exception e){
            j.setMsg(e.getMessage());
        }
        return j;
    }
}
