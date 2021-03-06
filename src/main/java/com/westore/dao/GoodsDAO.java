package com.westore.dao;

import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Location;
import com.westore.model.T_B_Order;

import java.util.List;
import java.util.Map;

public interface GoodsDAO {

    //商品操作
    public List<Map<String, Object>> findAll(Map<String, Object> paraMap);

    public void updateGoods(Map<String, Object> paraMap);

    public List<Integer> selectGoodsPoint(Map<String, Object> paraMap);

    public List<Map<String, Object>> softGoods(Map<String, Object> paraMap);
}
