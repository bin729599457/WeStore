package com.westore.service;

import com.westore.model.T_B_Goods;

import java.util.List;

public interface GoodsService {

    public List<T_B_Goods> findAllGoods();

    public List<T_B_Goods> findGoodsById();

    public List<T_B_Goods> findGoodsByName();

}
