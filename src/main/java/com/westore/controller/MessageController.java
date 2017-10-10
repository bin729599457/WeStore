package com.westore.controller;


import com.westore.model.AjaxJSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/MessageController")
public class MessageController {

    @RequestMapping(value = "/SendMessage.do" ,produces="application/json" ,method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object SendMessage(){
        AjaxJSON aj = new AjaxJSON();
        return aj;
    }

}
