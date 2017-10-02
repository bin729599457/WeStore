package com.westore.controller;

import com.westore.model.AjaxJSON;
import com.westore.service.UserService;
import net.sf.json.JSONObject;
import java.lang.Object;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

//hi

@Controller
@RequestMapping("/UserController")
public class UserController {

    @Resource
    private UserService userService;



    @RequestMapping(value="/login.do",produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public AjaxJSON Login(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        if(trd_session != null){
            String result = userService.checkLogin(trd_session);
            res.setMsg(result.equals("Logined")?"Login":"no Login");
            res.setSuccess(result.equals("Logined")?true:false);
        }
        else{
            String code = (String)params.get("code");
            String result = userService.Login(code);
            Map<String,Object> map = new HashMap<String, Object>();
            res.setSuccess(result.equals("error")?false:true);
            map.put("trd_session",result.equals("error")?null:result);
            res.setObj(map);
        }
        return res;
    }



    @RequestMapping(value="/change.do",produces="application/json" ,method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AjaxJSON changeUserMsg(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        String method = (String)params.get("method");
        AjaxJSON res = new AjaxJSON();
        if(trd_session == null||method == null) {
            res.setSuccess(false);
            res.setMsg("no Login or no method");
        }
        else {
            if(method.equals("phone")){
                String phone = (String)params.get("phone");
                String result = userService.change(trd_session,"phone",phone);
                res.setSuccess(result.equals("success")?true:false);
            }
            if(method.equals("password")){
                String password = (String)params.get("password");
                System.out.print(password);
                String result =userService.change(trd_session,"password",password);
                res.setSuccess(result.equals("success")?true:false);
            }
        }
        return res;
    }

    @RequestMapping(value="/getUserPassword.do",produces="application/json" ,method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AjaxJSON getUserPassword(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        int status = userService.getUserPassword(trd_session);
        res.setSuccess(status==-1?false:true);
        JSONObject json = new JSONObject();
        json.put("status",status);
        res.setObj(json);
        res.setMsg("-1:用户验证失败,0:用户未设置密码,1:用户已经设置密码");
        return res;
    }


    @RequestMapping(value="/checkUserPassword.do",produces="application/json" ,method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public AjaxJSON checkUserPassword(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        String password = (String)params.get("password");
        AjaxJSON res = new AjaxJSON();
        boolean status = userService.checkUserPassword(trd_session,password);
        res.setSuccess(status);
        res.setMsg(status == true?"验证成功":"验证失败");
        return res;
    }





}
