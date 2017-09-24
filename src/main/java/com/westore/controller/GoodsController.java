package com.westore.controller;

import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Order;
import com.westore.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/GoodsController")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping(value = "/getgoods.do")
    @ResponseBody
    public AjaxJSON getgoods(HttpServletRequest request) {
        AjaxJSON j = new AjaxJSON();

        try {

            Map<String, Object> paraMap = new HashMap<String, Object>();
            String id = request.getParameter("id") == null ? "" : request.getParameter("id");
            String user_id = request.getParameter("user_id") == null ? "" : request.getParameter("user_id");
            String order_date = request.getParameter("order_date") == null ? "" : request.getParameter("order_date");

            paraMap.put("id", id);
            paraMap.put("user_id", user_id);
            paraMap.put("order_date", order_date);
            List<T_B_Goods> goodsList = goodsService.findAllGoods(paraMap);
            j.setObj(goodsList);
            j.setMsg("查询订单列表成功");

        } catch (Exception e) {
            j.setMsg("" + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }

}
