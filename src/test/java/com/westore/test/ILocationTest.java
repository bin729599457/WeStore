package com.westore.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.CartDAO;
import com.westore.dao.CommonDAO;
import com.westore.dao.LocationDAO;
import com.westore.model.*;
import com.westore.service.CartService;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class ILocationTest {

    @Autowired
    private LocationService locationService;

    @Autowired
    private CartService cartService;

    @Autowired
    private LocationDAO locationDAO;

    @Resource
    private CommomService commomService;

    @Resource
    private RedisService redisService;

    @Resource
    private CommonDAO commonDAO;

    @Resource
    private CartDAO cartDAO;

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
        T_B_Comment comment = new T_B_Comment();
        comment.setId("12312");
        comment.setUser_id("oNuDy0FuszmkS6dHrk2ieWFfleMw");
        comment.setGoods_id("1824704943563473927");
        comment.setComment_info("okokok");
        comment.setComment_point(4);
        String sql = CommonUtils.add(comment);
        System.out.println(sql);
    }

    @Test
    public void testgetOpenid(){
       // System.out.println(redisService.insertHistory("1fbbabf684bc0ff3df822a67e04f9e0ef4259fff","hello"));
        List<String> search_queue = new ArrayList<String>();
        search_queue.add("goods1");
        search_queue.add("goods2");
        search_queue.add("goods3");
        System.out.println(search_queue.toString());
        QueueList q = new QueueList();
        q.setMax(3);
        q.setList(search_queue.toString());
        q.append("goods4");
        System.out.println(q.getList());

    }



}
