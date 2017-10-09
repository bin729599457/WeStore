package com.westore.dao;

import com.westore.model.T_B_Discount;

import java.util.List;
import java.util.Map;

public interface DiscountDAO {


    public int ifExist(T_B_Discount d);

    public List<Map<String,Object>> getUserDiscount(T_B_Discount d);

    public void deleteUserDiscount(T_B_Discount d);

}
