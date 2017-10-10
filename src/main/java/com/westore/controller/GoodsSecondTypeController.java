package com.westore.controller;

import com.github.pagehelper.PageInfo;
import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Goods_Second_Type;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.GoodsSecondTypeService;
import net.sf.json.JSONArray;
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
            String pageNum = (String)params.get("pageNum");
            String pageSize = (String)params.get("pageSize");
            PageInfo<Map<String,Object>> gst_list = goodsSecondTypeService.getGoodsSecondType(gst,pageNum,pageSize);
            aj.setObj(gst_list.getList());
            aj.setSuccess(true);
            aj.setTotal((long)gst_list.getTotal());
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


    @RequestMapping(value = "/updateGoodsSecondType.do" ,produces="application/json" ,method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object updateGoodsSecondType(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON aj = new AjaxJSON();
        try {
            T_B_Goods_Second_Type gst = (T_B_Goods_Second_Type) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Goods_Second_Type.class);
            String res = goodsSecondTypeService.updateGoodsSecondType(gst);
            String pageNum = (String)params.get("pageNum");
            PageInfo<Map<String,Object>> gst_list = goodsSecondTypeService.getGoodsSecondType(new T_B_Goods_Second_Type(),pageNum,"10");
            aj.setObj(gst_list.getList());
            aj.setTotal((long)gst_list.getTotal());
            aj.setSuccess(res.equals("success")?true:false);
            aj.setMsg(res);
        }catch (Exception e){
            aj.setMsg(e.getMessage());
            aj.setSuccess(false);
            return aj;
        }
        return aj;
    }


    @RequestMapping(value = "/deleteGoodsSecondType.do" ,produces="application/json" ,method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object deleteGoodsSecondType(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON aj = new AjaxJSON();
        try {
            T_B_Goods_Second_Type[] types=(T_B_Goods_Second_Type[]) JSONArray.toArray(JSONArray.fromObject(ajax.getObj()), T_B_Goods_Second_Type.class);
            String res = goodsSecondTypeService.deleteGoodsSecondType(types);
            String pageNum = (String)params.get("pageNum");
            PageInfo<Map<String,Object>> gst_list = goodsSecondTypeService.getGoodsSecondType(new T_B_Goods_Second_Type(),pageNum,"10");
            aj.setObj(gst_list.getList());
            aj.setTotal((long)gst_list.getTotal());
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
