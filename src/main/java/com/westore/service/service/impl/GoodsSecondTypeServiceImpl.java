package com.westore.service.service.impl;

import com.westore.dao.CommonDAO;
import com.westore.dao.GoodsSecondTypeDAO;
import com.westore.model.T_B_Goods_Second_Type;
import com.westore.service.GoodsSecondTypeService;
import com.westore.utils.CommonUtils;
import com.westore.utils.CustomUUID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodSecondTypeService")
public class GoodsSecondTypeServiceImpl implements GoodsSecondTypeService{

    @Resource
    private GoodsSecondTypeDAO goodsSecondTypeDAO;

    @Resource
    private CommonDAO commonDAO;

    public List<T_B_Goods_Second_Type> getGoodsSecondType(T_B_Goods_Second_Type gst) {
        return goodsSecondTypeDAO.getSecondTypes(gst);
    }

    public String insertGoodsSecondType(T_B_Goods_Second_Type gst) {
        try {
            int count = goodsSecondTypeDAO.ifExist(gst);
            if(count == 0) {
                gst.setId(CustomUUID.getFlowIdWorkerInstance().generate());
                String sql = CommonUtils.add(gst);
                //commonDAO.add(sql);
                System.out.println(sql);
                return "success";
            }
            return "已存在该类别";
        }catch (Exception e){
            return "error";
        }
    }
}
