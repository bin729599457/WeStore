package com.westore.utils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CommonUtils {

    private static CommonUtils commonUtils = new CommonUtils();

    public CommonUtils() {
    }

    public String add(Object object) {

        String className = object.getClass().getSimpleName();
        StringBuilder sql = new StringBuilder("insert into ");
        sql.append(className+" ");
        sql.append("set ");
        String str= getClassValueObj(object).toString().replace("{","").replace("}","");
        sql.append(str);
        return sql.toString();


    }


/*
    public String[] getClassVarName(Object object) {

        Field[] fields = object.getClass().getDeclaredFields();
        String[] varNames = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
            //获得目标类的接入权限
            boolean isAccess = fields[i].isAccessible();
            if (!isAccess) fields[i].setAccessible(true);
            varNames[i] = fields[i].getName();
            System.out.println(varNames[i]);

            if (!isAccess) fields[i].setAccessible(false);

        }
        return varNames;
    }
*/

    public Map<String, Object> getClassValueObj(Object object) {


        Field[] fields = object.getClass().getDeclaredFields();
//        Object[] valueObjs=new Object[fields.length];
        Map<String, Object> paraMap = new HashMap<String, Object>();
        for (int i = 0; i < fields.length; i++) {
            try {
                //获得目标类的接入权限
                boolean isAccess = fields[i].isAccessible();
                if (!isAccess) fields[i].setAccessible(true);

                //如果属性类型是字符串 加上' '
                if(fields[i].getGenericType().toString().equals("class java.lang.String")){
                    paraMap.put(fields[i].getName(), "'"+fields[i].get(object)+"'");

                }else if(fields[i].getGenericType().toString().equals(
                        "class java.util.Date")){
                    paraMap.put(fields[i].getName(), "'"+fields[i].get(object)+"'");

                }else {
                    paraMap.put(fields[i].getName(), fields[i].get(object));
                }


                if (!isAccess) fields[i].setAccessible(false);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(paraMap);
        return paraMap;
    }

    public static CommonUtils getCommomUtilsInstance() {
        return commonUtils;
    }
}
