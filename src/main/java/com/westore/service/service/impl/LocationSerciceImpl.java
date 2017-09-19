package com.westore.service.service.impl;

import com.westore.dao.LocationDAO;
import com.westore.model.T_B_Location;
import com.westore.service.LocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("locationService")
public class LocationSerciceImpl implements LocationService {

    @Resource
    private LocationDAO locationDAO;

    public List<T_B_Location> findAllLocation() {
        return locationDAO.findAll();
    }
}
