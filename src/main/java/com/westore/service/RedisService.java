package com.westore.service;

public interface RedisService {

    public String getOpenid(String trd_session);

    public int insertHistory(String trd_session,String goods_title);

    public String getSearch(String trd_session);

    public int clearSearch(String trd_session);

}
