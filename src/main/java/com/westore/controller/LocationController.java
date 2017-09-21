package com.westore.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.westore.model.T_B_Location;
import com.westore.model.T_B_User;
import com.westore.model.User;
import com.westore.service.LocationService;
import com.westore.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/LocationController")
public class LocationController {


    @Resource
    private LocationService locationService;

    @RequestMapping(value="/getUserLocation.do",produces="text/html;charset=UTF-8" ,method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object getUserlocation(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        if(trd_session == null){
            JSONObject resJSON = new JSONObject();
            resJSON.put("status","noLogin");
            return resJSON.toString();
        }
        else{
           return new T_B_Location();
        }

    }

}
