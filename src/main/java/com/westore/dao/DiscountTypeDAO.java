package com.westore.dao;

import com.westore.model.T_B_Discount_Type;

import java.util.List;

public interface DiscountTypeDAO {

    public List<T_B_Discount_Type> getAllDiscountType();

    public int ifExist(T_B_Discount_Type dt);

    public void updateDiscountType(T_B_Discount_Type dt);

}
