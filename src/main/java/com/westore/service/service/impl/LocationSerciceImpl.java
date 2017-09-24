package com.westore.service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.LocationDAO;
import com.westore.model.T_B_Location;
import com.westore.service.LocationService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("locationService")
public class LocationSerciceImpl implements LocationService {

    @Resource
    private LocationDAO locationDAO;

    @Resource
    private RedisTemplate redisTemplate;

    public List<T_B_Location> findAllLocation() {
        return locationDAO.findAll();
    }

    public PageInfo<T_B_Location> findUserLocation(String trd_session,String pageNum,String pageSize) {
        if(redisTemplate.opsForHash().entries(trd_session).isEmpty()){
            return null;
        }
        else{
            String openid = (String)redisTemplate.opsForHash().get(trd_session,"openid");
            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            PageInfo<T_B_Location> p_list = new PageInfo<T_B_Location>(locationDAO.findUserLocation(openid));
            return p_list;
        }

    }
}
