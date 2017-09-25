package com.westore.service.service.impl;

import com.westore.dao.GoodsDAO;
import com.westore.model.T_B_Goods;
import com.westore.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDAO goodsDAO;

    public List<T_B_Goods> selectGoods(Map<String, Object> paraMap) {
        return goodsDAO.findAll(paraMap);
    }

    public void updateGoods(Map<String, Object> paraMap) {
        return ;
    }

}
