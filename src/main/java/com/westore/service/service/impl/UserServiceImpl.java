package com.westore.service.service.impl;


import com.westore.dao.UserDAO;
import com.westore.model.T_B_User;
import com.westore.model.User;
import com.westore.service.UserService;
import com.westore.utils.CheckSumBuilder;
import com.westore.utils.CustomUUID;
import com.westore.utils.DesUtil;
import com.westore.utils.RequestUtils;
import net.sf.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
            String trd_sessionid = CheckSumBuilder.getCheckSum(openid,session_key);
            Map<String,String> map = new HashMap<String, String>();
            map.put("openid",openid);
            map.put("session_key",session_key);
            if(userDAO.ifExist(openid) == null){
                userDAO.insertUser(new T_B_User(CustomUUID.getFlowIdWorkerInstance().generate(),openid,null,null,null,null,0));
            }
            redisTemplate.opsForHash().putAll(trd_sessionid,map);
            redisTemplate.expire(trd_sessionid,20, TimeUnit.DAYS);
            return trd_sessionid;
        }
    }


    public String checkLogin(String trd_session) {

        return redisTemplate.opsForHash().entries(trd_session).isEmpty()?"noLogin":"Logined";

    }

    public String change(String trd_session,String method,String value) {
        if(redisTemplate.opsForHash().entries(trd_session).isEmpty()){
            return "error";
        }
        else{
            String openid = (String)redisTemplate.opsForHash().get(trd_session,"openid");
            if(method.equals("phone")){
                userDAO.updateUser(new T_B_User(null,openid,null,null,value,null,0));
            }
            else if (method.equals("password")){
                userDAO.updateUser(new T_B_User(null,openid,null,null,null, DesUtil.encrypt(value),0));
            }
            return "success";
        }

    }

    public float inqueryUserMoney(String user_id) {
        return userDAO.getUserMoney(user_id);
    }


}
