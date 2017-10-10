package com.westore.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.*;
import com.westore.model.*;
import com.westore.service.*;
import com.westore.service.service.impl.DiscountTypeServiceImpl;
import com.westore.utils.CommonUtils;
import com.westore.utils.CustomUUID;
import net.sf.json.JSONObject;
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

    @Resource
    private DiscountTypeDAO discountTypeDAO;

    @Resource
    private DiscountTypeService discountTypeService;

    @Resource
    private GoodsTypeService goodsTypeService;

    @Resource
    private DiscountDAO discountDAO;

    @Resource
    private GoodsSecondTypeDAO goodsSecondTypeDAO;

    @Resource
    private GoodsSecondTypeService goodsSecondTypeService;

    @Test
    public void findUserLocation(){
//        PageHelper.startPage(0, 0);
//        List<T_B_Location> list =  locationDAO.findUserLocation("oNuDy0FuszmkS6dHrk2ieWFfleMw");
//        PageInfo<T_B_Location> p_list = new PageInfo<T_B_Location>(list);
//        for(T_B_Location t:list){
//            System.out.println(t);
        List<T_B_Location> list =  locationService.findLocationById("1825716973611254785");
        System.out.println(list);
    }


    @Test
    public void testCommonDAO(){
        System.out.println(CommonUtils.covertToUrlList("book1.jpg,book2.jpg","https://www.westorehere.shop/img/"));
    }

    @Test
    public void testgetOpenid(){
       System.out.println(redisService.insertHistory("77400a57486374ff40d0b3937cd3f547d6a85ea5","芝士"));
//        List<String> search_queue = new ArrayList<String>();
//        search_queue.add("goods1");
//        search_queue.add("goods2");
//        search_queue.add("goods3");
//        search_queue.add("goods4");
//        System.out.println(search_queue.toString());
//        QueueList q = new QueueList();
//        q.setMax(3);
//        q.setList(search_queue.toString());
//        q.append("goods5");
//        System.out.println(q.getList());

    }

    @Test
    public void testFloat(){
        JSONObject jo = new JSONObject();
        jo.put("code","103");
        System.out.println(jo.get("codes").equals("200"));
    }

    @Test
    public void testDisType(){
        T_B_Discount_Type dt = new T_B_Discount_Type();
        dt.setId("1834444901845042185");
        dt.setMax_money(88);
        dt.setDiscount(8888);
        System.out.println(discountTypeService.updateDiscountType(dt));
    }

    @Test
    public void testDis(){
        T_B_Discount t = new T_B_Discount();
        t.setIs_used(0);
        t.setUser_id("oNuDy0FuszmkS6dHrk2ieWFfleMw");
        System.out.println(discountDAO.getUserDiscount(t));
    }

    @Test
    public void testType(){
        T_B_Goods_Second_Type gst = new T_B_Goods_Second_Type();
        //gst.setGoods_type_id("1834757824798786568");
        //gst.setGoods_second_type_name("大数据");
        //gst.setImg("bigdata.png");
        System.out.println(goodsSecondTypeService.getGoodsSecondType(gst,"0","0").getList());
    }

}
