package com.westore.controller;

import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.CommomService;
import com.westore.service.GoodsService;
import com.westore.utils.CustomUUID;
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
    @Resource
    private CommomService commomService;

    @RequestMapping(value = "/selectGoods.do")
    @ResponseBody
    public AjaxJSON selectGoods(HttpServletRequest request) {
        AjaxJSON j = new AjaxJSON();

        try {

            Map<String, Object> paraMap = new HashMap<String, Object>();
            String goods_title = request.getParameter("goods_title") == null ? "" : request.getParameter("goods_title");
            String goods_type_id = request.getParameter("goods_type_id") == null ? "" : request.getParameter("goods_type_id");
            String goods_descript = request.getParameter("goods_descript") == null ? "" : request.getParameter("goods_descript");
            String goods_price = request.getParameter("goods_price") == null ? "" : request.getParameter("goods_price");

            paraMap.put("goods_title", goods_title);
            paraMap.put("goods_type_id", goods_type_id);
            paraMap.put("goods_descript", goods_descript);
            paraMap.put("goods_price", goods_price);
            List<T_B_Goods> goodsList = goodsService.selectGoods(paraMap);

            if(goods_type_id!=null&&!goods_type_id.equals("")){
                List<Object> t_b_goods_typeList =commomService.get(new T_B_Goods_Type(),goods_type_id);
                T_B_Goods_Type t_b_goods_type=(T_B_Goods_Type)t_b_goods_typeList.get(0);
                String type_name=t_b_goods_type.getGoods_type_name();
            }


            j.setObj(goodsList);
            j.setMsg("查询订单列表成功");

        } catch (Exception e) {
            j.setMsg("查询订单失败" + e.getMessage());
            j.setSuccess(false);
            return j;
        }

        return j;
    }

    @RequestMapping(value = "/addGoods.do")
    @ResponseBody
    public AjaxJSON addGoods(HttpServletRequest request) {
        AjaxJSON j = new AjaxJSON();

        try {

            String goods_title = request.getParameter("goods_title") == null ? "" : request.getParameter("goods_title");
            String goods_type_id = request.getParameter("goods_type_id") == null ? "" : request.getParameter("goods_type_id");
            String goods_descript = request.getParameter("goods_descript") == null ? "" : request.getParameter("goods_descript");
            String goods_price = request.getParameter("goods_price") == null ? "" : request.getParameter("goods_price");
            String goods_images = request.getParameter("goods_images") == null ? "" : request.getParameter("goods_images");
            String goods_nums = request.getParameter("goods_nums") == null ? "" : request.getParameter("goods_nums");

            T_B_Goods t_b_goods=new T_B_Goods();
            t_b_goods.setId(CustomUUID.getFlowIdWorkerInstance().generate());
            t_b_goods.setGoods_title(goods_title);
            t_b_goods.setGoods_type_id(goods_type_id);
            t_b_goods.setGoods_descript(goods_descript);
            t_b_goods.setGoods_price(goods_price);
            t_b_goods.setGoods_images(goods_images);
            t_b_goods.setGoods_nums(Integer.parseInt(goods_nums));
            t_b_goods.setGoods_sales_nums(0);

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

}
