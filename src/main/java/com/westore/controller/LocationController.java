package com.westore.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageInfo;
import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Location;
import com.westore.model.T_B_User;
import com.westore.model.User;
import com.westore.service.LocationService;
import com.westore.service.UserService;
import com.westore.utils.CustomUUID;
import net.sf.json.JSON;
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


    @RequestMapping(value="/insertLocation.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object insertLocation(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON address){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        if(trd_session == null){
            res.setSuccess(false);
            res.setMsg("no Login");
        }
        else{
            T_B_Location loc = (T_B_Location) JSONObject.toBean(JSONObject.fromObject(address.getObj()), T_B_Location.class);
            loc.setId(CustomUUID.getFlowIdWorkerInstance().generate());
            String result = locationService.insertLocation(trd_session,loc);
            res.setSuccess((result == "error")?false:true);
        }
        return res;
    }


    @RequestMapping(value="/deleteLocation.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object deleteLocation(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON address){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        if(trd_session == null){
            res.setSuccess(false);
            res.setMsg("no Login");
        }
        else{
            T_B_Location loc = (T_B_Location) JSONObject.toBean(JSONObject.fromObject(address.getObj()), T_B_Location.class);
            String result = locationService.deleteLocation(trd_session,loc);
            res.setSuccess((result == "error")?false:true);
        }
        return res;
    }


    @RequestMapping(value="/updateLocation.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object updateLocation(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON address){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON res = new AjaxJSON();
        if(trd_session == null){
            res.setSuccess(false);
            res.setMsg("no Login");
        }
        else{
            T_B_Location loc = (T_B_Location) JSONObject.toBean(JSONObject.fromObject(address.getObj()), T_B_Location.class);
            String result = locationService.updateLocation(trd_session,loc);
            res.setSuccess((result == "error")?false:true);
        }
        return res;
    }

}
