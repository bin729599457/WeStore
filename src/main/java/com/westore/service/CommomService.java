package com.westore.service;

import java.util.List;
import java.util.Map;

public interface CommomService {

    public void add(Object object);

    public Map<String, Object> getClassValueObj(Object object);

    public List<Object> get(Object object, String id);

    public  String delete(Object object) ;

    }
