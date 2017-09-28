package com.westore.controller;


import com.github.pagehelper.PageInfo;
import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Cart;
import com.westore.service.CartService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        PageInfo<T_B_Cart> carts = cartService.findUserCart(trd_session,pageNum,pageSize);
        res.setSuccess((carts == null)?false:true);
        res.setObj(carts.getList());
        res.setTotal((carts == null)?0:carts.getTotal());
        return res;
    }


    @RequestMapping(value="/insertUserCart.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object insertUserCart(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON ajax){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        T_B_Cart cart = (T_B_Cart) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Cart.class);
        int result = cartService.insertUserCart(trd_session,cart);
        res.setSuccess(result==0?false:true);
        res.setMsg(result==0?"error":"success");
        System.out.println(result);
        res.setTotal((long)result);
        return res;
    }


    @RequestMapping(value="/deleteUserCart.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object deleteUserCart(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON ajax){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        T_B_Cart cart = (T_B_Cart) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Cart.class);
        String result = cartService.deleteUserCart(trd_session,cart);
        res.setSuccess(result==null?false:true);
        res.setMsg(result==null?"error":result);
       if(res!=null){
           PageInfo<T_B_Cart> carts = cartService.findUserCart(trd_session,"1","10");
           res.setObj(carts.getList());
           res.setTotal(carts.getTotal());
       }
        return res;
    }



}
