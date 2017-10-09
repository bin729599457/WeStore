package com.westore.controller;


import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Cart;
import com.westore.model.T_B_Discount;
import com.westore.service.DiscountService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("/DiscountController")
public class DiscountController {

    @Resource
    private DiscountService discountService;

    @RequestMapping(value="/insertDiscount.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object insertDiscount(@RequestParam Map<String,Object> params){
        AjaxJSON aj = new AjaxJSON();
        try{
            String discount_type = (String)params.get("discount_type");
            String trd_session = (String)params.get("trd_session");
            int res = discountService.insertDiscount(discount_type,trd_session);
            aj.setSuccess(res==1?true:false);
            JSONObject jo = new JSONObject();
            jo.put("status",res);
            aj.setObj(jo);
            aj.setMsg("-1表示领取失败，0表示已领取，1表示领取成功");
        }catch (Exception e){
            aj.setMsg(e.getMessage());
            aj.setSuccess(false);
            return aj;
        }
        return aj;
    }


    @RequestMapping(value="/getUserDiscount.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getUserDiscount(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON aj = new AjaxJSON();
        try{
            String trd_session = (String)params.get("trd_session");
            T_B_Discount d = (T_B_Discount) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Discount.class);
            List<Map<String,Object>> list = discountService.getUserDiscount(trd_session,d);
            aj.setObj(list);
            aj.setSuccess(list==null?false:true);
            aj.setTotal(list==null?(long)0:(long)list.size());
        }catch (Exception e){
            aj.setMsg(e.getMessage());
            aj.setSuccess(false);
            return aj;
        }
        return aj;
    }
}
