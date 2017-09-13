package com.westore.test;


import com.westore.dao.IUserDAO;
import com.westore.model.User;
import com.westore.service.IUserService;
import com.westore.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDAOTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testFindAll(){
        List<User> userList = userService.findAllUser();
        for(User u:userList){
            System.out.print(u);
        }
    }


}
