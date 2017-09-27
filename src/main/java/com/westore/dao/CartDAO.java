package com.westore.dao;

import com.westore.model.T_B_Cart;
import com.westore.model.T_B_Location;

import java.util.List;

public interface CartDAO {

    public List<T_B_Cart> findUserCart(String user_id);

}
