package com.westore.service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.CommonDAO;
import com.westore.dao.LocationDAO;
import com.westore.model.T_B_Location;
import com.westore.service.LocationService;
import com.westore.service.RedisService;
import com.westore.utils.CommonUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("locationService")
public class LocationSerciceImpl implements LocationService {

    @Resource
    private LocationDAO locationDAO;

    @Resource
    private RedisService redisService;

    @Resource
    private CommonDAO commonDAO;

    public List<T_B_Location> findAllLocation() {
        return locationDAO.findAll();
    }

    public PageInfo<T_B_Location> findUserLocation(String trd_session,String pageNum,String pageSize) {

        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return null;
        }
        else {
            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            PageInfo<T_B_Location> p_list = new PageInfo<T_B_Location>(locationDAO.findUserLocation(openid));
            return p_list;

        }
    }

    public String insertLocation(String trd_session,T_B_Location location){

        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return "error";
        }
        else{
            location.setUser_id(openid);
            if(location.getIs_default() == 1) {
                locationDAO.setUndefault(openid);
            }
            String sql = CommonUtils.add(location);
            commonDAO.add(sql);
            return "success";
        }
    }


    public String deleteLocation(String trd_session,T_B_Location location){
        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return "error";
        }
        else{
            location.setUser_id(openid);
            String sql = CommonUtils.delete(location);
            commonDAO.delete(sql);
            return "success";
        }
    }

    public String updateLocation(String trd_session,T_B_Location location){
        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return "error";
        }
        else{
            location.setUser_id(openid);
            if(location.getIs_default() == 1) {
                locationDAO.setUndefault(openid);
            }
            locationDAO.updateUserLocation(location);
            return "success";
        }
    }


}
