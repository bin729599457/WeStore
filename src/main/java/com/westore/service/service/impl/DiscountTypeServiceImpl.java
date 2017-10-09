package com.westore.service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.CommonDAO;
import com.westore.dao.DiscountDAO;
import com.westore.dao.DiscountTypeDAO;
import com.westore.model.T_B_Discount;
import com.westore.model.T_B_Discount_Type;
import com.westore.model.T_B_Location;
import com.westore.service.DiscountService;
import com.westore.service.DiscountTypeService;
import com.westore.utils.CommonUtils;
import com.westore.utils.CustomUUID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("discountTypeService")
public class DiscountTypeServiceImpl implements DiscountTypeService {


    @Resource
    private DiscountTypeDAO discountTypeDAO;

    @Resource
    private DiscountDAO discountDAO;

    @Resource
    private CommonDAO commonDAO;

    public PageInfo<T_B_Discount_Type> getAllDiscountType(String pageNum,String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        PageInfo<T_B_Discount_Type> p_list = new PageInfo<T_B_Discount_Type>(discountTypeDAO.getAllDiscountType());
        return p_list;
    }


    public Object insetyDiscountType(T_B_Discount_Type dt) {
        dt.setId(CustomUUID.getFlowIdWorkerInstance().generate());
        String sql = CommonUtils.add(dt);
        commonDAO.add(sql);
        return dt;
    }

    public String deleteDiscountType(T_B_Discount_Type[] dts) {
        if(dts.length==0){
            return "error";
        }
        else {
            try {
                for(T_B_Discount_Type dt:dts) {
                    String sql = CommonUtils.delete(dt);
                    commonDAO.delete(sql);
                    T_B_Discount d = new T_B_Discount();
                    d.setDiscount_type(dt.getId());
                    discountDAO.deleteUserDiscount(d);
                }
                return "success";
            } catch (Exception e) {
                return "error";
            }
        }
    }
}
