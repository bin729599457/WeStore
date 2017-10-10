package com.westore.dao;

import com.westore.model.T_B_Goods_Second_Type;

import java.util.List;

public interface GoodsSecondTypeDAO {


    public List<T_B_Goods_Second_Type> getSecondTypes(T_B_Goods_Second_Type gst);

    public int ifExist(T_B_Goods_Second_Type gst);

    public void updateSecondTypes(T_B_Goods_Second_Type gst);

}
