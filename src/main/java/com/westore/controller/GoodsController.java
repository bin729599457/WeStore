package com.westore.controller;

import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.CommomService;
import com.westore.service.GoodsService;
import com.westore.utils.CustomUUID;
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
@RequestMapping("/GoodsController")
public class GoodsController {

    @Resource
    private GoodsService goodsService;
    @Resource
    private CommomService commomService;

    @RequestMapping(value = "/selectGoods.do")
    @ResponseBody
    public AjaxJSON selectGoods(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON obj) {
        AjaxJSON j = new AjaxJSON();

        try {

            Map<String, Object> paraMap = new HashMap<String, Object>();
            T_B_Goods t_b_goods= (T_B_Goods) JSONObject.toBean(JSONObject.fromObject(obj.getObj()),T_B_Goods.class);
            String goods_price_low = (String)params.get("goods_price_low");
            String goods_price_high = (String)params.get("goods_price_high");
            if(t_b_goods.getGoods_descript()!=null) {
                paraMap.put("goods_title", '%' + t_b_goods.getGoods_title() + '%');
            }
            paraMap.put("goods_type_id", t_b_goods.getGoods_type_id());
            if(t_b_goods.getGoods_descript()!=null) {
                paraMap.put("goods_descript", '%' + t_b_goods.getGoods_descript() + '%');
            }
            paraMap.put("goods_price_low", goods_price_low);
            paraMap.put("goods_price_high", goods_price_high);
            paraMap.put("goods_author", t_b_goods.getGoods_author());
            paraMap.put("goods_publisher", t_b_goods.getGoods_publisher());
            List<T_B_Goods> goodsList = goodsService.selectGoods(paraMap);

            j.setObj(goodsList);
            j.setTotal((long)goodsList.size());
            j.setMsg("查询商品列表成功");

        } catch (Exception e) {
            j.setMsg("查询商品失败" + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }

    @RequestMapping(value = "/addGoods.do")
    @ResponseBody
    public AjaxJSON addGoods(@RequestParam Map<String,Object> params, @RequestBody AjaxJSON obj) {
        AjaxJSON j = new AjaxJSON();

        try {

            T_B_Goods t_b_goods= (T_B_Goods) JSONObject.toBean(JSONObject.fromObject(obj.getObj()),T_B_Goods.class);
            t_b_goods.setId(CustomUUID.getFlowIdWorkerInstance().generate());
            t_b_goods.setGoods_sales_nums(0);
            t_b_goods.setGoods_point(0);

            commomService.add(t_b_goods);

            j.setObj(t_b_goods);
            j.setMsg("添加商品成功");

        } catch (Exception e) {
            j.setMsg("添加商品失败 " + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }

    @RequestMapping(value = "/delGoods.do")
    @ResponseBody
    public AjaxJSON delGoods(HttpServletRequest request) {
        AjaxJSON j = new AjaxJSON();

        try {

            String goods_id = request.getParameter("goods_id") == null ? "" : request.getParameter("goods_id");
            T_B_Goods t_b_goods=new T_B_Goods();
            t_b_goods.setId(goods_id);

            String sql=commomService.delete(t_b_goods);

            j.setObj(sql);
            j.setMsg("删除商品成功");

        } catch (Exception e) {
            j.setMsg("删除商品失败 " + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }

    @RequestMapping(value = "/UpdateGoods.do")
    @ResponseBody
    public AjaxJSON UpdateGoods(HttpServletRequest request) {
        AjaxJSON j = new AjaxJSON();

        try {

            String goods_id = request.getParameter("goods_id") == null ? "" : request.getParameter("goods_id");
            String goods_title = request.getParameter("goods_title") == null ? "" : request.getParameter("goods_title");
            String goods_type_id = request.getParameter("goods_type_id") == null ? "" : request.getParameter("goods_type_id");
            String goods_descript = request.getParameter("goods_descript") == null ? "" : request.getParameter("goods_descript");
            String goods_price = request.getParameter("goods_price") == null ? "" : request.getParameter("goods_price");
            String goods_images = request.getParameter("goods_images") == null ? "" : request.getParameter("goods_images");
            String goods_nums = request.getParameter("goods_nums") == null ? "" : request.getParameter("goods_nums");
            String goods_point = request.getParameter("goods_point") == null ? "" : request.getParameter("goods_point");
            String goods_author = request.getParameter("goods_author") == null ? "" : request.getParameter("goods_author");
            String goods_publisher = request.getParameter("goods_publisher") == null ? "" : request.getParameter("goods_publisher");

            if(goods_id==null&&goods_id.equals("")){
                j.setSuccess(false);
                j.setMsg("goods_id为空");
                return j;
            }

            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put("id",goods_id);
            paraMap.put("goods_title",goods_title);
            paraMap.put("goods_type_id",goods_type_id);
            paraMap.put("goods_descript",goods_descript);
            paraMap.put("goods_price",goods_price);
            paraMap.put("goods_images",goods_images);
            paraMap.put("goods_nums",goods_nums);
            paraMap.put("goods_point",goods_point);
            paraMap.put("goods_author",goods_author);
            paraMap.put("goods_publisher",goods_publisher);

            goodsService.updateGoods(paraMap);

            j.setObj(paraMap);
            j.setMsg("更新商品成功");

        } catch (Exception e) {
            j.setMsg("更新商品失败 " + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }

    @RequestMapping(value = "/softGoods.do")
    @ResponseBody
    public AjaxJSON softGoods(HttpServletRequest request) {
        AjaxJSON j = new AjaxJSON();

        try {

            String goods_price = request.getParameter("goods_price") == null ? "" : request.getParameter("goods_price");
            String goods_sales_nums = request.getParameter("goods_sales_nums") == null ? "" : request.getParameter("goods_sales_nums");
            String goods_point = request.getParameter("goods_point") == null ? "" : request.getParameter("goods_point");

            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put("goods_price",goods_price);
            paraMap.put("goods_sales_nums",goods_sales_nums);
            paraMap.put("goods_point",goods_point);

            //排序条件只可以提供一个
            if(goods_price!=null&&!goods_price.equals("")){
                goods_sales_nums="";goods_point="";
                List<T_B_Goods> goodsList=goodsService.softGoods(paraMap);
                j.setObj(goodsList);
                j.setMsg("商品排序成功");
                j.setTotal((long)goodsList.size());
                return j;
            }
            if(goods_sales_nums!=null&&!goods_sales_nums.equals("")){
                goods_price="";goods_point="";
                List<T_B_Goods> goodsList=goodsService.softGoods(paraMap);
                j.setObj(goodsList);
                j.setTotal((long)goodsList.size());
                j.setMsg("商品排序成功");
                return j;
            }
            if(goods_point!=null&&!goods_point.equals("")){
                goods_price="";goods_sales_nums="";
                List<T_B_Goods> goodsList=goodsService.softGoods(paraMap);
                j.setObj(goodsList);
                j.setTotal((long)goodsList.size());
                j.setMsg("商品排序成功");
                return j;
            }



        } catch (Exception e) {
            j.setMsg("商品排序失败 " + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }

}
