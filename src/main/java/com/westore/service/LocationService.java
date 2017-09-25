package com.westore.service;

import com.github.pagehelper.PageInfo;
import com.westore.model.T_B_Location;
import com.westore.utils.CommonUtils;

import java.util.List;

public interface LocationService {

    public List<T_B_Location> findAllLocation();

    public PageInfo<T_B_Location> findUserLocation(String trd_session,String pageNum,String pageSize);

    public String insertLocation(String trd_session,T_B_Location location);

    public String deleteLocation(String trd_session,T_B_Location location);

    public String updateLocation(String trd_session,T_B_Location location);
}
