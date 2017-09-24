package com.westore.service;

import com.github.pagehelper.PageInfo;
import com.westore.model.T_B_Location;

import java.util.List;

public interface LocationService {

    public List<T_B_Location> findAllLocation();

    public PageInfo<T_B_Location> findUserLocation(String trd_session,String pageNum,String pageSize);

}
