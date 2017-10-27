package com.westore.utils;

import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.CommomService;

import javax.annotation.Resource;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1l, "abc");
        System.out.println(map.get(1));
        System.out.println(map.get(1l));

    }

}
