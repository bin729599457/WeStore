package com.westore.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageInfo;
import com.westore.model.AjaxJSON;
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

    @RequestMapping(value="/getUserLocation.do" ,produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public Object getUserlocation(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        if(trd_session == null){
            res.setSuccess(false);
            res.setMsg("no Login");
        }
        else{
            String pageNum = (String)params.get("pageNum");
            String pageSize = (String)params.get("pageSize");
            PageInfo<T_B_Location> locations = locationService.findUserLocation(trd_session,pageNum,pageSize);
            res.setSuccess((locations == null)?false:true);
            res.setObj(locations);
            res.setTotal((locations == null)?0:locations.getTotal());
        }
        return res;
    }

}
