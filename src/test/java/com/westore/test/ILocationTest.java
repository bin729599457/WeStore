package com.westore.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.CommonDAO;
import com.westore.dao.LocationDAO;
import com.westore.model.T_B_Location;
import com.westore.model.T_B_User;
import com.westore.service.CommomService;
import com.westore.service.LocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.reflect.annotation.TypeAnnotation;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class ILocationTest {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationDAO locationDAO;

    @Resource
    private CommomService commomService;

    @Test
    public void findUserLocation(){
        PageHelper.startPage(0, 0);
        List<T_B_Location> list =  locationDAO.findUserLocation("oNuDy0FuszmkS6dHrk2ieWFfleMw");
        PageInfo<T_B_Location> p_list = new PageInfo<T_B_Location>(list);
        for(T_B_Location t:list){
            System.out.println(t);
        }
    }

    @Test
    public void testCommonDAO(){
        T_B_Location  loc = new T_B_Location();
        loc.setId("123456");
        loc.setUser_id("uuu123123");
        loc.setUser_location("abxaxb");
        loc.setUser_phone("15019936488");
        loc.setUser_name("tom");
        loc.setIs_default(0);
        commomService.add(loc);
    }



}
