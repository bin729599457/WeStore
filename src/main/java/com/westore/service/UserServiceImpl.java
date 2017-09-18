package com.westore.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.westore.dao.UserDAO;
import com.westore.model.User;
import com.westore.utils.RequestUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final String appid = "wxfd21b79973f49459";
    private static final String app_se= "094ca7963f55405b23af1dafd702e012";
    private static final String url="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    @Resource
    private UserDAO userDAO;

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
            return "success";
        }
    }
}
