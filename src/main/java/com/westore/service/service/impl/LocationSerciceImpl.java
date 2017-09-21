package com.westore.service.service.impl;

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

    public List<T_B_Location> findUserLocation(String trd_session) {
        if(redisTemplate.opsForHash().entries(trd_session).isEmpty()){
            return null;
        }

        return null;
    }
}
