package com.westore.controller;


import com.github.pagehelper.PageInfo;
import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Location;
import com.westore.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/CartController")
public class CartController {

    @Resource
    private CartService cartService;

    @RequestMapping(value="/getUserCart.do" ,produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public Object getUserCart(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        String pageNum = (String)params.get("pageNum");
        String pageSize = (String)params.get("pageSize");
        PageInfo<T_B_Location> carts = cartService.findUserCart(trd_session,pageNum,pageSize);
        res.setSuccess((carts == null)?false:true);
        res.setObj(carts);
        res.setTotal((carts == null)?0:carts.getTotal());
        return res;
    }



}
