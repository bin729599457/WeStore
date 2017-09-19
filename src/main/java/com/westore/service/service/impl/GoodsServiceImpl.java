package com.westore.service.service.impl;

import com.westore.dao.GoodsDAO;
import com.westore.model.T_B_Goods;
import com.westore.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDAO goodsDAO;

    public List<T_B_Goods> findAllGoods() {
        return goodsDAO.findAll();
    }

    public List<T_B_Goods> findGoodsById() {
        return goodsDAO.findById();
    }

    public List<T_B_Goods> findGoodsByName() {
        return goodsDAO.findByName();
    }
}
