package com.westore.controller;


import com.github.pagehelper.PageInfo;
import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Cart;
import com.westore.model.T_B_Comment;
import com.westore.model.T_B_Location;
import com.westore.service.CommentService;
import com.westore.service.LocationService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.plugin.dom.core.Comment;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/CommentController")
public class CommentController {


    @Resource
    private CommentService commentService;



    @RequestMapping(value="/getBookComment.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getUserlocation(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON res = new AjaxJSON();
        String pageNum = (String)params.get("pageNum");
        String pageSize = (String)params.get("pageSize");
        T_B_Comment com = (T_B_Comment) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Comment.class);
        PageInfo<T_B_Comment> p_comment = commentService.getBookComment(com.getGoods_id(),pageNum,pageSize);
        res.setSuccess(true);
        res.setTotal(p_comment.getTotal());
        res.setObj(p_comment.getList());
        return res;
    }


    @RequestMapping(value="/getBookCommentMath.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getBookCommentMath(@RequestParam Map<String,Object> params,@RequestBody AjaxJSON ajax){
        AjaxJSON res = new AjaxJSON();
        T_B_Comment com = (T_B_Comment) JSONObject.toBean(JSONObject.fromObject(ajax.getObj()), T_B_Comment.class);
        int commentNum = commentService.getBookCommentNum(com.getGoods_id());
        float commentPointAvg = commentService.getBookCommentAvg(com.getGoods_id());
        res.setSuccess(true);
        JSONObject json = new JSONObject();
        json.put("commentNum",commentNum);
        json.put("avgPoint",commentPointAvg);
        res.setObj(json);
        return res;
    }

}
