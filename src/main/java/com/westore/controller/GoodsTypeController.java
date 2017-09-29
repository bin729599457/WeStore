package com.westore.controller;


import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Goods_Second_Type;
import com.westore.model.T_B_Goods_Type;
import com.westore.model.T_B_Order;
import com.westore.service.CommomService;
import com.westore.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("/GoodsTypeController")
public class GoodsTypeController {

    @Resource
    private OrderService orderService;
    @Resource
    private CommomService commomService;

    @RequestMapping(value = "/getTypes.do")
    @ResponseBody
    public AjaxJSON getTypes(HttpServletRequest request) {
        AjaxJSON j = new AjaxJSON();

        try {
            List<Map<String, Object>> objList = commomService.getAll(new T_B_Goods_Type());
            j.setObj(objList);
            j.setMsg("查询一级商品类型列表成功");
            j.setTotal((long)objList.size());

        } catch (Exception e) {
            j.setMsg("查询一级商品类型列表失败" + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }

    @RequestMapping(value = "/getSecondTypes.do")
    @ResponseBody
    public AjaxJSON getSecondTypes(HttpServletRequest request) {
        AjaxJSON j = new AjaxJSON();

        try {
            List<Map<String, Object>> objList = commomService.getAll(new T_B_Goods_Second_Type());
            j.setObj(objList);
            j.setMsg("查询二级商品类型列表成功");
            j.setTotal((long)objList.size());


        } catch (Exception e) {
            j.setMsg("查询二级商品类型列表失败" + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }

}
