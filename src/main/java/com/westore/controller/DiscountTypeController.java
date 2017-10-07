package com.westore.controller;


import com.github.pagehelper.PageInfo;
import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Comment;
import com.westore.model.T_B_Discount_Type;
import com.westore.service.DiscountTypeService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("/DiscountTypeController")
public class DiscountTypeController {

    @Resource
    private DiscountTypeService discountTypeService;

    @RequestMapping(value="/getDiscountType.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getDiscountType(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON ajax){
        AjaxJSON aj = new AjaxJSON();
        try{
            String pageNum = (String)params.get("pageNum");
            String pageSize = (String)params.get("pageSize");
            PageInfo<T_B_Discount_Type> p = discountTypeService.getAllDiscountType(pageNum,pageSize);
            aj.setObj(p.getList());
            aj.setSuccess(true);
            aj.setTotal(p.getTotal());
            aj.setMsg("查询成功,max表示额度，discount表示减多少");
        }catch (Exception e){
            aj.setMsg(e.getMessage());
            aj.setSuccess(false);
            return aj;
        }
        return aj;
    }


    @RequestMapping(value="/insertDiscountType.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object insertDiscountType(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON ajax){
        AjaxJSON aj = new AjaxJSON();
        try{
            T_B_Discount_Type dt = (T_B_Discount_Type) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Discount_Type.class);
            discountTypeService.insetyDiscountType(dt);
        }catch (Exception e){
            aj.setMsg(e.getMessage());
            aj.setSuccess(false);
            return aj;
        }
        return aj;
    }


}
