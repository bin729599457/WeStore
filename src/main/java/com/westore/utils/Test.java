package com.westore.utils;

import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.CommomService;

import javax.annotation.Resource;
import java.util.*;

public class Test {

    public static void main(String[] args) {
/*
        List<String> stringList = new ArrayList<String>();
        stringList.add("141");
        stringList.add("141");
        stringList.add("141");
        stringList.add("141");
        stringList.add("141");

        Iterator<String> iterator=stringList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        Map<String, Object> paraMap = new HashMap<String, Object>();
        //HashMap的Key可以为空值
        paraMap.put(null,"null");//null
        paraMap.put(null,"null2");//null2
        System.out.println(paraMap.get(null));

    }

}
