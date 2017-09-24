package com.westore.service;

import com.westore.model.T_B_Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    public List<T_B_Goods> findAllGoods(Map<String, Object> paraMap);



}
