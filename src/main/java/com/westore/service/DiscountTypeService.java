package com.westore.service;

import com.github.pagehelper.PageInfo;
import com.westore.model.T_B_Discount_Type;

public interface DiscountTypeService {

    public PageInfo<T_B_Discount_Type> getAllDiscountType(String pageNum,String pageSize);

    public Object insetyDiscountType(T_B_Discount_Type dt);

}
