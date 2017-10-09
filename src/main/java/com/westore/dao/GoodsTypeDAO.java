package com.westore.dao;

import com.westore.model.T_B_Goods_Type;

import java.util.List;

public interface GoodsTypeDAO {

    public List<T_B_Goods_Type> getAllTypes();

    public int ifExist(T_B_Goods_Type t);

}
