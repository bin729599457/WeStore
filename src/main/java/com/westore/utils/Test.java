package com.westore.utils;

import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.CommomService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<String>();
        stringList.add("141");
        stringList.add("141");
        stringList.add("141");
        stringList.add("141");
        stringList.add("141");

        Iterator<String> iterator=stringList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
