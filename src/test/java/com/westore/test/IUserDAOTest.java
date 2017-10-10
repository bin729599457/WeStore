package com.westore.test;


import com.westore.dao.CartDAO;
import com.westore.dao.CommentDAO;
import com.westore.model.T_B_Cart;
import com.westore.model.T_B_Location;
import com.westore.model.User;
import com.westore.service.CommentService;
import com.westore.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.plugin.dom.core.Comment;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class IUserDAOTest {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testFindAll(){
        List<User> userList = userService.findAllUser();
        for(User u:userList){
            System.out.print(u);
        }
    }


    @Test
    public void testFindCart(){
        System.out.println(cartDAO.ifExist("oNuDy0FuszmkS6dHrk2ieWFfleMw","1824757527376561152"));
    }

    @Test
    public void testFindComment(){

        System.out.println(userService.checkUserPassword("6d60793ff434a8c75c40b54082722315ddfa8943","111111"));
    }


}
