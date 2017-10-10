package com.westore.service;

import com.github.pagehelper.PageInfo;
import com.westore.model.T_B_Goods_Second_Type;

import java.util.List;
import java.util.Map;

public interface GoodsSecondTypeService  {

    public PageInfo<Map<String,Object>> getGoodsSecondType(T_B_Goods_Second_Type gst, String pageNum, String pageSize);

    public String insertGoodsSecondType(T_B_Goods_Second_Type gst);

    public String updateGoodsSecondType(T_B_Goods_Second_Type gst);

    public String deleteGoodsSecondType(T_B_Goods_Second_Type[] gst);

}
