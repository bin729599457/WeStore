package com.westore.service.service.impl;

import com.westore.dao.CommonDAO;
import com.westore.service.CommomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Service("CommomService")
public class CommomServiceImpl implements CommomService {

    @Resource
    private CommonDAO commonDAO;

    public void add(Object object) {

        String className = object.getClass().getSimpleName();
        StringBuilder sql = new StringBuilder("insert into ");
        sql.append(className+" ");
        sql.append("set ");
        String str= getClassValueObj(object).toString().replace("{","").replace("}","");
        sql.append(str);
        System.out.println(sql);

        Map<String, Object> paraMap=new HashMap<String, Object>();
        paraMap.put("sql",sql);

        commonDAO.addOrder(paraMap);

    }

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
                    paraMap.put(fields[i].getName(), "'now'");

                }else {
                    paraMap.put(fields[i].getName(), fields[i].get(object));
                }


                if (!isAccess) fields[i].setAccessible(false);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(paraMap);
        return paraMap;
    }

}
