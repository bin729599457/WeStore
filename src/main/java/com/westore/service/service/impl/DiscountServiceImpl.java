package com.westore.service.service.impl;

import com.westore.dao.CommonDAO;
import com.westore.dao.DiscountDAO;
import com.westore.model.T_B_Discount;
import com.westore.service.DiscountService;
import com.westore.service.RedisService;
import com.westore.utils.CommonUtils;
import com.westore.utils.CustomUUID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.naming.ldap.PagedResultsControl;
import java.util.List;
import java.util.Map;

@Service("discountService")
public class DiscountServiceImpl implements DiscountService{

    @Resource
    private RedisService redisService;

    @Resource
    private CommonDAO commonDAO;

    @Resource
    private DiscountDAO discountDAO;


    public int insertDiscount(String discount_type,String trd_session){
        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return -1;
        }
        else {
            T_B_Discount d = new T_B_Discount(openid,discount_type);
            int count = discountDAO.ifExist(d);
            if(count==0) {
                d.setId(CustomUUID.getFlowIdWorkerInstance().generate());
                d.setIs_used(0);
                String sql = CommonUtils.add(d);
                System.out.println(sql);
                commonDAO.add(sql);
                return 1;
            }
            return 0;
        }
    }



    public List<Map<String,Object>> getUserDiscount(String trd_session, T_B_Discount t){
        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return null;
        }
        else {
            t.setUser_id(openid);
            List<Map<String,Object>> list = discountDAO.getUserDiscount(t);
            return list;
        }
    }

}
