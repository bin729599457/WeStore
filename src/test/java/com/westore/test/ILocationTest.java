package com.westore.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.LocationDAO;
import com.westore.model.T_B_Location;
import com.westore.service.LocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.reflect.annotation.TypeAnnotation;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class ILocationTest {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationDAO locationDAO;

    @Test
    public void findUserLocation(){
        PageHelper.startPage(0, 0);
        List<T_B_Location> list =  locationDAO.findUserLocation("oNuDy0FuszmkS6dHrk2ieWFfleMw");
        PageInfo<T_B_Location> p_list = new PageInfo<T_B_Location>(list);
        for(T_B_Location t:list){
            System.out.println(t);
        }
    }

}
