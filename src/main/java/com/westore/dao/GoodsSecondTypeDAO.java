package com.westore.dao;

import com.westore.model.T_B_Goods_Second_Type;

import java.util.List;
import java.util.Map;

public interface GoodsSecondTypeDAO {


    public List<Map<String,Object>> getSecondTypes(T_B_Goods_Second_Type gst);

    public int ifExist(T_B_Goods_Second_Type gst);

    public void updateSecondTypes(T_B_Goods_Second_Type gst);

}
