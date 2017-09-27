package com.westore.service;


import com.github.pagehelper.PageInfo;
import com.westore.model.T_B_Cart;
import com.westore.model.T_B_Location;

public interface CartService {

    public PageInfo<T_B_Cart> findUserCart(String trd_session, String pageNum, String pageSize);
}
