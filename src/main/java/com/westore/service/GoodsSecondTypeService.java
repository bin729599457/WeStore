package com.westore.service;

import com.westore.model.T_B_Goods_Second_Type;

import java.util.List;

public interface GoodsSecondTypeService  {

    public List<T_B_Goods_Second_Type> getGoodsSecondType(T_B_Goods_Second_Type gst);
    public String insertGoodsSecondType(T_B_Goods_Second_Type gst);
}
