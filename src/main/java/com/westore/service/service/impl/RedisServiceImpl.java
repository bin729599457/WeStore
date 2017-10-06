package com.westore.service.service.impl;

import com.westore.model.QueueList;
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
            String sereach = (String) redisTemplate.opsForHash().get(trd_session, "search");
            if (sereach == null || sereach.equals("")) {
                List<String> list = new ArrayList<String>();
                list.add(goods_title);
                redisTemplate.opsForHash().put(trd_session, "search", list.toString());
                return 1;
            }
            else {
                QueueList ql = new QueueList();
                ql.setMax(10);
                ql.setList(sereach);
                ql.append(goods_title);
                redisTemplate.opsForHash().put(trd_session, "search", ql.toString());
                return 1;
            }
        }
    }

    public String getSearch(String trd_session){
        if(redisTemplate.opsForHash().entries(trd_session).isEmpty()){
            return null;
        }
        else {
            return  (String) redisTemplate.opsForHash().get(trd_session, "search");
        }
    }

    public int clearSearch(String trd_session) {
        if(redisTemplate.opsForHash().entries(trd_session).isEmpty()){
            return 0;
        }
        else {
            redisTemplate.opsForHash().put(trd_session,"search","");
            return 1;
        }
    }
}
