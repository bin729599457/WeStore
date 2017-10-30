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
        System.out.println("php".hashCode() == "c++".hashCode());

        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            if(iterator.next()!=4){

                System.out.println(iterator.next());
            }else {
                System.out.println("NO");
            }
        }

    }


}
