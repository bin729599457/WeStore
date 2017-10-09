package com.westore.service;

import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Goods_Type;

import java.util.List;

public interface GoodsTypeService {

    public List<T_B_Goods_Type> getAllTypes();

    public String insertTypes(T_B_Goods_Type t);

    public String updateTypes(T_B_Goods_Type t);

    public String deleteTypes(T_B_Goods_Type t);
}
