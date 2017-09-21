package com.westore.controller;

import com.westore.model.T_B_User;
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



    @RequestMapping(value="/login.do",produces="text/html;charset=UTF-8" ,method = RequestMethod.GET)
    @ResponseBody
    public String Login(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        JSONObject resultJSON = new JSONObject();
        if(trd_session != null){
            resultJSON.put("status",userService.checkLogin(trd_session));
        }
        else{
            String code = (String)params.get("code");
            String res = userService.Login(code);
            if(res.equals("error")){
                resultJSON.put("status","error");
            }
            else{
                resultJSON.put("trd_session",res);
            }
        }
        return resultJSON.toString();
    }

    @RequestMapping(value="/change.do",produces="text/html;charset=UTF-8" ,method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String changeUserMsg(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        String method = (String)params.get("method");
        JSONObject resultJSON = new JSONObject();
        if(trd_session == null||method == null) {
            resultJSON.put("status", "noLogin or noMethod");
        }
        else {
            if(method.equals("phone")){
                String phone = (String)params.get("phone");
                resultJSON.put("status",userService.change(trd_session,"phone",phone));
            }

            if(method.equals("password")){
                String password = (String)params.get("password");
                System.out.print(password);
                resultJSON.put("status",userService.change(trd_session,"password",password));
            }
        }
        return resultJSON.toString();
    }




}
