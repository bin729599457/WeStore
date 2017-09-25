package com.westore.service;

import com.westore.model.T_B_Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    public List<T_B_Goods> selectGoods(Map<String, Object> paraMap);

    public void updateGoods(Map<String, Object> paraMap);

}
