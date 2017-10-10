package com.westore.utils;

import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.CommomService;

import javax.annotation.Resource;
import java.util.Map;

public class Test {

    @Resource
    public static CommomService commomService;

    public static void main(String[] args) {
/*        String basestr = "123456";
        String str1 = DesUtil.encrypt(basestr);

        System.out.println("原始值: " + basestr);
        System.out.println("加密后: " + str1);
        System.out.println("解密后: " + DesUtil.decrypt(str1));
        System.out.println("为空时 is : " + DesUtil.decrypt(DesUtil.encrypt("")));*/

        goods_weight_Calculate(4,"1834466086519571465");


    }

    public static void goods_weight_Calculate(float new_point,String goods_id) {

        Map<String,Object> obj = commomService.getObject(new T_B_Goods(),goods_id);
        obj.get("is_discounted");
        obj.get("goods_weights");
        obj.get("goods_point");

    }

}
