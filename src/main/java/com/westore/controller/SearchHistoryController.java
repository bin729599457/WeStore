package com.westore.controller;

import com.westore.model.AjaxJSON;
import com.westore.model.QueueList;
import com.westore.service.RedisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/SearchHistoryController")
public class SearchHistoryController {

    @Resource
    private RedisService redisService;

    @RequestMapping(value = "/getSearch.do" ,produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public Object getUserSerach(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON aj = new AjaxJSON();
        try {
            String search = redisService.getSearch(trd_session);
            QueueList q = new QueueList();
            q.setList(search);
            aj.setObj(q.getList());
            aj.setSuccess(true);
            aj.setMsg("查询搜索记录成功");
        }catch (Exception e){
            aj.setSuccess(false);
            aj.setMsg(e.getMessage());
            return aj;
        }
        return aj;
    }


    @RequestMapping(value = "/clearSearch.do" ,produces="application/json" ,method = RequestMethod.GET)
    @ResponseBody
    public Object clearSearch(@RequestParam Map<String,Object> params){
        String trd_session = (String)params.get("trd_session");
        AjaxJSON aj = new AjaxJSON();
        try {
            int res = redisService.clearSearch(trd_session);
            aj.setSuccess(res == 0?false:true);
        }catch (Exception e){
            aj.setSuccess(false);
            aj.setMsg(e.getMessage());
            return aj;
        }
        return aj;
    }

}
