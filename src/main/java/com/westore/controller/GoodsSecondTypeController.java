package com.westore.controller;

import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Goods_Second_Type;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.GoodsSecondTypeService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("/GoodsSecondTypeController")
public class GoodsSecondTypeController {

    @Resource
    private GoodsSecondTypeService goodsSecondTypeService;

    @RequestMapping(value = "/getGoodsSecondType.do" ,produces="application/json" ,method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object getGoodsSecondType(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON aj = new AjaxJSON();
        try {
            T_B_Goods_Second_Type gst = (T_B_Goods_Second_Type) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Goods_Second_Type.class);
            List<T_B_Goods_Second_Type> gst_list = goodsSecondTypeService.getGoodsSecondType(gst);
            aj.setObj(gst_list);
            aj.setSuccess(true);
            aj.setTotal((long)gst_list.size());
        }catch (Exception e){
            aj.setMsg(e.getMessage());
            aj.setSuccess(false);
            return aj;
        }
        return aj;
    }


    @RequestMapping(value = "/insertGoodsSecondType.do" ,produces="application/json" ,method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object insertGoodsSecondType(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON aj = new AjaxJSON();
        try {
            T_B_Goods_Second_Type gst = (T_B_Goods_Second_Type) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Goods_Second_Type.class);
            String res = goodsSecondTypeService.insertGoodsSecondType(gst);
            aj.setSuccess(res.equals("success")?true:false);
            aj.setMsg(res);
        }catch (Exception e){
            aj.setMsg(e.getMessage());
            aj.setSuccess(false);
            return aj;
        }
        return aj;
    }

}
