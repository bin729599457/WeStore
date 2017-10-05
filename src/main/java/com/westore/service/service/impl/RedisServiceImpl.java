package com.westore.service.service.impl;

import com.westore.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("redisService")
public class RedisServiceImpl  implements RedisService {

    @Resource
    private RedisTemplate redisTemplate;


    public String getOpenid(String trd_session) {
        return  (String) redisTemplate.opsForHash().get(trd_session,"openid");
    }


    public int insertHistory(String trd_session, String goods_title) {
        if(redisTemplate.opsForHash().entries(trd_session).isEmpty()){
            return 0;
        }
        else {
            LinkedList<String> sereach = (LinkedList<String>) redisTemplate.opsForHash().get(trd_session, "search");
            if (sereach == null) {
                Queue<String> search_queue = new LinkedList<String>();
                search_queue.offer(goods_title);
                redisTemplate.opsForHash().put(trd_session, "search", search_queue.toString());
                return 1;
            }
            else {
                System.out.println(sereach.size());
                return 1;
            }
        }
    }
}
