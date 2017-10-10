package com.westore.service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.CommonDAO;
import com.westore.dao.GoodsSecondTypeDAO;
import com.westore.model.T_B_Discount_Type;
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


    public PageInfo<T_B_Goods_Second_Type> getGoodsSecondType(T_B_Goods_Second_Type gst,String pageNum,String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(pageSize));
        PageInfo<T_B_Goods_Second_Type> p_list = new PageInfo<T_B_Goods_Second_Type>(goodsSecondTypeDAO.getSecondTypes(gst));
        return p_list;
    }

    public String insertGoodsSecondType(T_B_Goods_Second_Type gst) {
        try {
            int count = goodsSecondTypeDAO.ifExist(gst);
            if(count == 0) {
                gst.setId(CustomUUID.getFlowIdWorkerInstance().generate());
                String sql = CommonUtils.add(gst);
                commonDAO.add(sql);
                return "success";
            }
            return "已存在该类别";
        }catch (Exception e){
            return "error";
        }
    }


    public String updateGoodsSecondType(T_B_Goods_Second_Type gst) {
        try {
            if(gst.getId().equals("0")){
                return "该类别无法修改";
            }
            goodsSecondTypeDAO.updateSecondTypes(gst);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }
}
