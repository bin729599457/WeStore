package com.westore.service;

import com.github.pagehelper.PageInfo;
import com.westore.model.T_B_Goods_Second_Type;

import java.util.List;

public interface GoodsSecondTypeService  {

    public PageInfo<T_B_Goods_Second_Type> getGoodsSecondType(T_B_Goods_Second_Type gst, String pageNum, String pageSize);

    public String insertGoodsSecondType(T_B_Goods_Second_Type gst);

    public String updateGoodsSecondType(T_B_Goods_Second_Type gst);
}
