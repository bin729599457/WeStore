package com.westore.service.service.impl;

import com.westore.dao.CommonDAO;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.CommomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("CommomService")
public class CommomServiceImpl implements CommomService {

    @Resource
    private CommonDAO commonDAO;

    public void add(Object object) {

        String className = object.getClass().getSimpleName();
        StringBuilder sql = new StringBuilder("insert into ");
        sql.append(className + " ");
        sql.append("set ");
        String str = getClassValueObj(object).toString().replace("{", "").replace("}", "");
        sql.append(str);

        commonDAO.add(sql.toString());

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
                if (fields[i].getGenericType().toString().equals("class java.lang.String")) {
                    paraMap.put(fields[i].getName(), "'" + fields[i].get(object) + "'");

                } else if (fields[i].getGenericType().toString().equals(
                        "class java.util.Date")) {
                    paraMap.put(fields[i].getName(), "'" + fields[i].get(object).toString() + "'");

                } else {
                    paraMap.put(fields[i].getName(), fields[i].get(object));
                }


                if (!isAccess) fields[i].setAccessible(false);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return paraMap;
    }

    public List<Map<String, Object>> getAll(Object object) {

        StringBuilder sql = new StringBuilder("select ");
        Field[] fields = object.getClass().getDeclaredFields();
        int count = 1;
        for (Field field : fields) {
            if (count < fields.length) {
                sql.append(field.getName());
                sql.append(",");
                count ++;
            } else {
                sql.append(field.getName());
            }
        }
        sql.append(" from ");
        sql.append(object.getClass().getSimpleName());
        List<Map<String, Object>> classList = commonDAO.selectAll(sql.toString());

        return classList;
    }

    public String delete(Object object) {

        String className = object.getClass().getSimpleName();
        StringBuilder sql = new StringBuilder("delete from ");
        sql.append(className + " ");
        sql.append("where id=");
        String str = (String) getClassValueObj(object).get("id");
        sql.append(str);
        commonDAO.delete(sql.toString());
        return sql.toString();

    }

    public Map<String,Object> get(Object object,String user_id) {

        StringBuilder sql = new StringBuilder("select * from ");
        sql.append(object.getClass().getSimpleName());
        sql.append(" where user_id= ");
        sql.append("'"+user_id+"'");
        Map<String,Object> obj = commonDAO.get(sql.toString());

        return obj;
    }

}
