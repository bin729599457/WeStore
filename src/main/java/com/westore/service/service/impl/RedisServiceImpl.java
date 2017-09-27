package com.westore.service.service.impl;

import com.westore.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("redisService")
public class RedisServiceImpl  implements RedisService {

    @Resource
    private RedisTemplate redisTemplate;


    public String getOpenid(String trd_session) {
        return  (String) redisTemplate.opsForHash().get(trd_session,"openid");
    }



}
