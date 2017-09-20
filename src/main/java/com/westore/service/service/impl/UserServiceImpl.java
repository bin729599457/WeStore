package com.westore.service.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.westore.dao.UserDAO;
import com.westore.model.User;
import com.westore.service.UserService;
import com.westore.utils.CheckSumBuilder;
import com.westore.utils.RequestUtils;
import net.sf.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final String appid = "wxfd21b79973f49459";
    private static final String app_se= "094ca7963f55405b23af1dafd702e012";
    private static final String url="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    @Resource
    private UserDAO userDAO;

    @Resource
    private RedisTemplate redisTemplate;

    public List<User> findAllUser(){
            return this.userDAO.findAll();
    }

    public String Login(String code){
        String app_url = url.replace("APPID",appid).replace("SECRET",app_se).replace("JSCODE",code);
        JSONObject resultJSON = JSONObject.fromObject(RequestUtils.httpRequest(app_url));
        if(resultJSON.containsKey("errcode")){
            return "error";
        }
        else {
            String openid = resultJSON.getString("openid");
            String session_key = resultJSON.getString("session_key");
            String trd_sessionid = CheckSumBuilder.getCheckSum(openid,session_key,String.valueOf((new Date().getTime()/1000L)));
            Map<String,String> map = new HashMap<String, String>();
            map.put("openid",openid);
            map.put("session_key",session_key);
            redisTemplate.opsForHash().putAll(trd_sessionid,map);
            return trd_sessionid;
        }
    }
}
