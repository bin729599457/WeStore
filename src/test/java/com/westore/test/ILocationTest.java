package com.westore.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.CommonDAO;
import com.westore.dao.LocationDAO;
import com.westore.model.T_B_Location;
import com.westore.service.CommomService;
import com.westore.service.LocationService;
import com.westore.service.RedisService;
import com.westore.utils.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


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

    @Resource
    private RedisService redisService;

    @Resource
    private CommonDAO commonDAO;

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
        loc.setId("1824430639907079169");
        String sql = CommonUtils.delete(loc);
        commonDAO.delete(sql);
    }

    @Test
    public void testgetOpenid(){
        System.out.println(redisService.getOpenid("1fbbabf684bc0ff3df822a67e04f9e0ef4259fff"));
    }



}
