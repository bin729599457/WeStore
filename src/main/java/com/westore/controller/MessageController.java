package com.westore.controller;


import com.westore.model.AjaxJSON;
import com.westore.utils.MessageRequestUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/MessageController")
public class MessageController {

    @RequestMapping(value = "/SendMessage.do" ,produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public Object SendMessage(@RequestParam Map<String,Object> params){
        AjaxJSON aj = new AjaxJSON();
        try{
            String phone = (String)params.get("phone");
            String res = MessageRequestUtils.SendRequest(phone);
            JSONObject jo = JSONObject.fromObject(res);
            aj.setObj(jo);
            aj.setSuccess(true);
        }catch (Exception e){
            aj.setMsg(e.getMessage());
            aj.setSuccess(false);
            return aj;
        }
        return aj;
    }




}
