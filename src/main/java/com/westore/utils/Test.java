package com.westore.utils;

import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.CommomService;

import javax.annotation.Resource;
import java.util.*;

public class Test {

    private int testNum=0;
    private String testStr="hello";

    public static void main(String[] args) {
        /*
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(null, 0);
        map.put("java", 1);
        map.put("c++", 2);
        map.put("python", 3);
        map.put("php", 4);
        map.put("nodejs", 5);
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("php".hashCode() == "c++".hashCode());*/

        ArrayList arrayList=new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("a");

        Collections.reverse(arrayList);
        System.out.println(arrayList);// 输出结果为[B, A]


    }


}
