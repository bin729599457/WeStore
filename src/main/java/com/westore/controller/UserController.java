package com.westore.controller;

import com.westore.model.User;
import com.westore.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/UserController")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value="/getAllUser.do",produces="text/html;charset=UTF-8" ,method = RequestMethod.GET)
    @ResponseBody
    public String getAllUser(){
        JSONArray userListJSON = new JSONArray();
        List<User> userList = userService.findAllUser();
        for(User u : userList){
            JSONObject user = new JSONObject();
            user.put("id",u.getId());
            user.put("name",u.getName());
            user.put("sex",u.getSex());
            userListJSON.add(user);
        }
        System.out.println(userListJSON.toString());
        return userListJSON.toString();
    }

    @RequestMapping(value="/login.do",produces="text/html;charset=UTF-8" ,method = RequestMethod.GET)
    @ResponseBody
    public String Login(@RequestParam Map<String,Object> params){
        String trd_srssion = (String)params.get("trd_srssion");
        JSONObject resultJSON = new JSONObject();
        if(trd_srssion != null){
        }
        else{
            String code = (String)params.get("code");
            String res = userService.Login(code);
            if(res.equals("success")){
                resultJSON.put("status","success");
            }
            else{
                resultJSON.put("status","error");
            }
        }
        return resultJSON.toString();
    }


}
