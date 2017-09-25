package com.westore.dao;

import java.util.List;
import java.util.Map;

public interface CommonDAO {

    public void add(String sql);

    public List<Object> selectById(Map<String ,Object> paraMap);

    public void delete(String sql);


}
