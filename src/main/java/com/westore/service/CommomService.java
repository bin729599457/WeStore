package com.westore.service;

import java.util.List;
import java.util.Map;

public interface CommomService {

    public void add(Object object);

    public Map<String, Object> getClassValueObj(Object object);

    public List<Map<String, Object>> getAll(Object object);

    public  String delete(Object object) ;

    public Map<String,Object> get(Object object,String id);

    public Map<String,Object> getObject(Object object,String id);

    public void goods_weight_Calculate(float new_point,String goods_id);
}
