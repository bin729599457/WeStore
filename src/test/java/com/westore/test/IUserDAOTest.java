package com.westore.test;


import com.westore.dao.CartDAO;
import com.westore.model.T_B_Cart;
import com.westore.model.T_B_Location;
import com.westore.model.User;
import com.westore.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-redis.xml"})
public class IUserDAOTest {

    @Autowired
    private UserService userService;

    @Autowired
    private CartDAO cartDAO;

    @Test
    public void testFindAll(){
        List<User> userList = userService.findAllUser();
        for(User u:userList){
            System.out.print(u);
        }
    }


    @Test
    public void testFindCart(){
        List<T_B_Cart> ca = cartDAO.findUserCart("oNuDy0JpnJfpfZiIy1pBlyjcpYak");
        for(T_B_Cart tc:ca){
            System.out.print(tc);
        }
    }


}
