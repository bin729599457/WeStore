package com.westore.service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.CartDAO;
import com.westore.model.T_B_Cart;
import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Location;
import com.westore.service.CartService;
import com.westore.service.RedisService;

import javax.annotation.Resource;

public class CartServiceImpl implements CartService {

    @Resource
    private RedisService redisService;

    @Resource
    private CartDAO cartDAO;

    public PageInfo<T_B_Cart> findUserCart(String trd_session, String pageNum, String pageSize) {
        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return null;
        }
        else {
            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            PageInfo<T_B_Cart> p_list = new PageInfo<T_B_Cart>(cartDAO.findUserCart(openid));
            return p_list;
        }
    }
}
