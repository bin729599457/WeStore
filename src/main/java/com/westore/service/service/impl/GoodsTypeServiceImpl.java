package com.westore.service.service.impl;

import com.westore.dao.CommonDAO;
import com.westore.dao.GoodsTypeDAO;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.GoodsTypeService;
import com.westore.utils.CommonUtils;
import com.westore.utils.CustomUUID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsTypeService")
public class GoodsTypeServiceImpl implements GoodsTypeService{

    @Resource
    private GoodsTypeDAO goodsTypeDAO;

    @Resource
    private CommonDAO commonDAO;

    public List<T_B_Goods_Type> getAllTypes() {
        return goodsTypeDAO.getAllTypes();
    }

    public String insertTypes(T_B_Goods_Type t){
        int count = goodsTypeDAO.ifExist(t);
        if (count == 0){
            t.setId(CustomUUID.getFlowIdWorkerInstance().generate());
            String sql = CommonUtils.add(t);
            System.out.println(sql);
            commonDAO.add(sql);
        return "success";
    }
        return "已存在该类别";
}

    public String updateTypes(T_B_Goods_Type t){
        if (t.getId().equals("0")){
            return "该类别不可更改";
        }
        int count = goodsTypeDAO.ifExist(t);
        if (count == 0){
            goodsTypeDAO.updateTypes(t);
            return "success";
        }
        return "已存在该类别";
    }

    public String deleteTypes(T_B_Goods_Type[] ts) {
        if(ts.length!=0) {
            for (T_B_Goods_Type t:ts) {
                if(!t.getId().equals("0")) {
                    String sql = CommonUtils.delete(t);
                    commonDAO.delete(sql);
                }
            }
            return "success";
        }
        return "false";
    }
}
