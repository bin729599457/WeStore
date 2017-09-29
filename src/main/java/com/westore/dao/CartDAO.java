package com.westore.dao;

import com.westore.model.T_B_Cart;
import com.westore.model.T_B_Location;

import java.util.List;

public interface CartDAO {

    public List<T_B_Cart> findUserCart(String user_id);

    public String insertUserCart(String sql);

    public T_B_Cart ifExist(String user_id,String goods_id);

    public void updateUserCart(String user_id,String goods_id,int num);

    public int getTotal(String user_id);

}
