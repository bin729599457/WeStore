package com.westore.controller;

import com.westore.model.*;
import com.westore.service.*;
import com.westore.service.service.impl.CommomServiceImpl;
import com.westore.utils.CustomUUID;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("/OrderController")
public class OrderController {

    public static String IMAGE_HOME_URL="https://www.westorehere.shop/img/";

    @Resource
    private OrderService orderService;
    @Resource
    private CommomService commomService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private UserService userService;
    @Resource
    private RedisService redisService;

    @RequestMapping(value = "/getOrders.do")
    @ResponseBody
    public AjaxJSON getOrders(@RequestParam Map<String,Object> params) {
        AjaxJSON j = new AjaxJSON();

        try {

            //需要获得单个订单详情
            String id = (String) params.get("order_id");
            String user_id= redisService.getOpenid((String) params.get("trd_session"));
            String order_start_date = (String) params.get("order_start_date");
            String order_over_date = (String) params.get("order_over_date");

            if(user_id==null&&user_id.equals("")){
                j.setSuccess(false);
                j.setMsg("user_id为空");
                return j;
            }

            Map<String, Object> paraMap = new HashMap<String, Object>();

            paraMap.put("id", id);
            paraMap.put("user_id", user_id);
            paraMap.put("order_start_date", order_start_date);
            paraMap.put("order_over_date", order_over_date);

            List<Map<String, Object>> ordersList = orderService.findOrders(paraMap);
            List<Map<String, Object>> ordersDetailList = new ArrayList<Map<String, Object>>();
            Map<String, Object> orderDetaileMap=new HashMap<String, Object>();
            for(Map<String, Object> order:ordersList){
                orderDetaileMap.put("orderMessage",order);
                Map<String, Object> detailMap=new HashMap<String, Object>();
                detailMap.put("order_id",(String) order.get("order_id"));
                List<Map<String, Object>> goodsDetailList=orderService.getOrdersDetail(detailMap);
                for(Map<String, Object> goodsMap:goodsDetailList){
                    String str=(String) goodsMap.get("goods_images");
                    String[] imagesList= str.split(",");
                    for(String s:imagesList){
                        s=IMAGE_HOME_URL+s;
                    }
                    goodsMap.put("goods_images",imagesList.toString());
                }
                orderDetaileMap.put("goodsDetail",goodsDetailList);
                ordersDetailList.add(orderDetaileMap);
            }
            j.setObj(ordersDetailList);
            j.setMsg("查询订单列表成功");
            j.setTotal((long)ordersDetailList.size());

        } catch (Exception e) {
            j.setMsg("查询订单列表失败" + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }

    @RequestMapping(value = "/payOrders.do")
    @ResponseBody
    public AjaxJSON payOrders(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON obj) {
        AjaxJSON j = new AjaxJSON();

        try {
            String trd_session= (String) params.get("trd_session");
            String order_id= (String) params.get("order_id");
            String user_id= redisService.getOpenid(trd_session);
            float total_money= Float.parseFloat((String) params.get("total_money"));
            String password= (String) params.get("password");
            //获得用户对象,封装在Map上
            Map<String,Object> userMap=commomService.get(new T_B_User(),user_id);

            //判断用户密码是否输入正确
            if(userService.checkUserPassword(trd_session,password)){
                j.setSuccess(false);
                j.setMsg("用户密码输入不正确!");
                return j;
            }

            //判断用户余额是否足够支付订单
            if(total_money>(Float)userMap.get("user_money")){
                j.setSuccess(false);
                j.setMsg("用户余额不足!");
                return j;
            }

            //获得商品详情列表
            List t_b_order_detail_list= (List) JSONArray.fromObject(obj.getObj());

            for(int i=0;i<t_b_order_detail_list.size();i++){
                Map<String,Object> map= (Map<String, Object>) t_b_order_detail_list.get(i);
                Map<String,Object> goodsDetail= (Map<String, Object>) map.get("t_b_order_detail");
                Map<String,Object> paraMap=new HashMap<String,Object>();
                paraMap.put("id",(String) goodsDetail.get("goods_id"));
                paraMap.put("goods_nums_change",Integer.parseInt((String) goodsDetail.get("goods_num")));
                goodsService.updateGoods(paraMap);
            }
            //下单成功 扣除用户余额
            userService.change(trd_session,"money","-"+(String) params.get("total_money"));

            //修改订单状态
            Map<String,Object> updateOrderStatus =new HashMap<String, Object>();
            updateOrderStatus.put("order_state",1);
            updateOrderStatus.put("id",order_id);
            orderService.updateOrder(updateOrderStatus);

            j.setObj(t_b_order_detail_list);
            j.setMsg("支付订单成功");

        } catch (Exception e) {
            j.setMsg("支付订单成功失败" + e.getMessage());
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

            String user_id= redisService.getOpenid((String) params.get("trd_session"));
            String total_money= (String) params.get("total_money");
            String location_id=(String) params.get("location_id");

            if(user_id==null&&user_id.equals("")){
                j.setMsg("user_id为空");
                j.setSuccess(false);
                return j;
            }

            if(total_money==null&&total_money.equals("")){
                j.setMsg("订单金额为空");
                j.setSuccess(false);
                return j;
            }

            if(location_id==null&&location_id.equals("")){
                j.setMsg("地址信息为空");
                j.setSuccess(false);
                return j;
            }

            SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");

            T_B_Order t_b_order=new T_B_Order();
            t_b_order.setId(CustomUUID.getFlowIdWorkerInstance().generate());
            t_b_order.setUser_id(user_id);
            t_b_order.setOrder_date(ft.format(new Date()));
            t_b_order.setOrder_state(0);
            t_b_order.setTotal_money(Float.parseFloat(total_money));
            t_b_order.setLocation_id(location_id);


            //获得商品详情列表
            List t_b_order_detail_list= (List) JSONArray.fromObject(obj.getObj());


            List<T_B_Order_Detail> t_b_order_detailList=new ArrayList<T_B_Order_Detail>();
            for(int i=0;i<t_b_order_detail_list.size();i++){
                Map<String,Object> map= (Map<String, Object>) t_b_order_detail_list.get(i);
                T_B_Order_Detail t_b_order_detail=new T_B_Order_Detail();
                t_b_order_detail.setId(CustomUUID.getFlowIdWorkerInstance().generate());
                t_b_order_detail.setGoods_id((String) map.get("goods_id"));
                t_b_order_detail.setGoods_num(Integer.parseInt((String) map.get("goods_num")) );
                t_b_order_detail.setOrder_id(t_b_order.getId());
                commomService.add(t_b_order_detail);
                t_b_order_detailList.add(t_b_order_detail);
            }
            commomService.add(t_b_order);

            Map<String,Object> paraMap=new HashMap<String,Object>();
            paraMap.put("t_b_order",t_b_order);
            paraMap.put("t_b_order_detailList",t_b_order_detailList);

            j.setObj(paraMap);
            j.setMsg("订单及订单详情生成成功");

        }catch (Exception e){
            j.setSuccess(false);
            j.setMsg("订单及订单详情生成失败"+e.getMessage());
            return j;
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
            j.setMsg("删除订单成功");


        }catch (Exception e){
            j.setMsg(e.getMessage());
        }
        return j;
    }

    @RequestMapping(value = "/updateOrder.do")
    @ResponseBody
    public AjaxJSON updateOrder(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON obj){
        AjaxJSON j=new AjaxJSON();

        try {

            String order_id = (String) params.get("order_id");
            String order_state = (String) params.get("order_state");

            if(order_id==null&&order_id.equals("")){
                j.setSuccess(false);
                j.setMsg("order_id为空");
                return j;
            }

            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put("id", order_id);
            paraMap.put("order_state",order_state);
            orderService.updateOrder(paraMap);
            j.setMsg("修改订单成功");


        }catch (Exception e){
            j.setMsg("修改订单失败"+e.getMessage());
        }
        return j;
    }


}
