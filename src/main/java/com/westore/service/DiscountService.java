package com.westore.service;

import com.westore.model.T_B_Discount;

import java.util.List;
import java.util.Map;

public interface DiscountService {

    public int insertDiscount(String discount_type,String trd_session);

    public List<Map<String,Object>> getUserDiscount(String trd_session, T_B_Discount t);

    public String updateUserDiscount(String trd_session, T_B_Discount t);

}
