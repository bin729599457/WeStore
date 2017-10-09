package com.westore.service;

import com.github.pagehelper.PageInfo;
import com.westore.model.T_B_Discount_Type;

public interface DiscountTypeService {

    public PageInfo<T_B_Discount_Type> getAllDiscountType(String pageNum,String pageSize);

    public String insetyDiscountType(T_B_Discount_Type dt);

    public String deleteDiscountType(T_B_Discount_Type[] dts);

    public String updateDiscountType(T_B_Discount_Type dt);

}
