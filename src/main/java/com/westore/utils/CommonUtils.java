package com.westore.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtils {



    public static String covertToUrlList(String files,String url){
        String[] file =  files.split(",");
        List<String> list = new ArrayList<String>();
        for(String f:file){
            list.add(url+f);
        }
        return list.toString().replace("[","").replace("]","");
    }


    public static String add(Object object) {

        String className = object.getClass().getSimpleName();
        StringBuilder sql = new StringBuilder("insert into ");
        sql.append(className+" ");
        sql.append("set ");
        String str= getClassValueObj(object).toString().replace("{","").replace("}","");
        sql.append(str);
        return sql.toString();


    }


    public static String delete(Object object) {

        String className = object.getClass().getSimpleName();
        StringBuilder sql = new StringBuilder("delete from ");
        sql.append(className+" ");
        sql.append("where id=");
        String str= (String)getClassValueObj(object).get("id");
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

    public static Map<String, Object> getClassValueObj(Object object) {


        Field[] fields = object.getClass().getDeclaredFields();
//        Object[] valueObjs=new Object[fields.length];
        Map<String, Object> paraMap = new HashMap<String, Object>();
        for (int i = 0; i < fields.length; i++) {
            try {
                //获得目标类的接入权限
                boolean isAccess = fields[i].isAccessible();
                if (!isAccess) fields[i].setAccessible(true);
                //System.out.println(fields[i].get(object).getClass());
                //如果属性类型是字符串 加上' '
                if(fields[i].getGenericType().toString().equals("class java.lang.String")){
                    paraMap.put(fields[i].getName(), "'"+fields[i].get(object)+"'");

                }else if(fields[i].getGenericType().toString().equals(
                        "class java.util.Date")){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
                    paraMap.put(fields[i].getName(), "'"+sdf.format(new Date().getTime())+"'");
                }else if(fields[i].getGenericType().toString().equals(
                        "class com.westore.model.T_B_Goods")&&fields[i].get(object)!=null){
                    Field id =fields[i].get(object).getClass().getDeclaredField("id");
                    id.setAccessible(true);
                    paraMap.put(fields[i].getName()+"_id", id.get(fields[i].get(object)));
                    id.setAccessible(false);
                }
                else {
                    paraMap.put(fields[i].getName(), fields[i].get(object));
                }


                if (!isAccess) fields[i].setAccessible(false);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(paraMap);
        return paraMap;
    }
}
