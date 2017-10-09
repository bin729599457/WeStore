package com.westore.controller;


import com.westore.model.*;
import com.westore.service.CommomService;
import com.westore.service.GoodsTypeService;
import com.westore.service.OrderService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    private CommomService commomService;

    @Resource
    private GoodsTypeService goodsTypeService;

    @RequestMapping(value = "/getAllTypes.do")
    @ResponseBody
    public AjaxJSON getTypes(HttpServletRequest request) {
        AjaxJSON j = new AjaxJSON();
        try {
            List<T_B_Goods_Type> objList = goodsTypeService.getAllTypes();
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


    @RequestMapping(value = "/insertTypes.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public AjaxJSON insertTypes(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax) {
        AjaxJSON j = new AjaxJSON();
        try {
            T_B_Goods_Type t = (T_B_Goods_Type) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Goods_Type.class);
            String res = goodsTypeService.insertTypes(t);
            List<T_B_Goods_Type> objList = goodsTypeService.getAllTypes();
            j.setMsg(res);
            j.setSuccess(res.equals("success")?true:false);
            j.setObj(objList);
            j.setTotal((long)objList.size());
        } catch (Exception e) {
            j.setMsg("增加一级分类失败" + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }


    @RequestMapping(value = "/updateTypes.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public AjaxJSON updateTypes(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax) {
        AjaxJSON j = new AjaxJSON();
        try {
            T_B_Goods_Type t = (T_B_Goods_Type) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Goods_Type.class);
            String res = goodsTypeService.updateTypes(t);
            List<T_B_Goods_Type> objList = goodsTypeService.getAllTypes();
            j.setMsg(res);
            j.setSuccess(res.equals("success")?true:false);
            j.setObj(objList);
            j.setTotal((long)objList.size());
        } catch (Exception e) {
            j.setMsg("修改一级分类失败" + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }


    @RequestMapping(value = "/deleteTypes.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public AjaxJSON deleteTypes(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax) {
        AjaxJSON j = new AjaxJSON();
        try {
            T_B_Goods_Type t = (T_B_Goods_Type) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Goods_Type.class);
            String res = goodsTypeService.deleteTypes(t);
            List<T_B_Goods_Type> objList = goodsTypeService.getAllTypes();
            j.setMsg(res);
            j.setSuccess(res.equals("success")?true:false);
            j.setObj(objList);
            j.setTotal((long)objList.size());
        } catch (Exception e) {
            j.setMsg("修改一级分类失败" + e.getMessage());
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
