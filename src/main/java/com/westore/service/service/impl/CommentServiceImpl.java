package com.westore.service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.CommentDAO;
import com.westore.dao.CommonDAO;
import com.westore.model.T_B_Comment;
import com.westore.model.T_B_Location;
import com.westore.service.CommentService;
import com.westore.service.RedisService;
import com.westore.utils.CommonUtils;
import com.westore.utils.CustomUUID;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("commentService")
public class CommentServiceImpl implements CommentService{


    @Resource
    private RedisService redisService;

    @Resource
    private CommentDAO commentDAO;

    @Resource
    private CommonDAO commonDAO;


    public PageInfo<T_B_Comment> getBookComment(String goods_id, String pageNum, String pageSize) {
            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            PageInfo<T_B_Comment> p_list = new PageInfo<T_B_Comment>(commentDAO.getBookComment(goods_id));
            return p_list;
    }

    public int getBookCommentNum(String goods_id) {
        return commentDAO.getBookCommentNum(goods_id);
    }

//   此方法已经在数据库中使用trigger实现
//    public float getBookCommentAvg(String goods_id) {
//        return commentDAO.getBookCommentAvg(goods_id);
//    }


    public int insertBookComment(String trd_session, T_B_Comment comment) {
        String openid = redisService.getOpenid(trd_session);
        if(openid == null){
            return 0;
        }
        else {
            comment.setUser_id(openid);
            comment.setId(CustomUUID.getFlowIdWorkerInstance().generate());
            String sql = CommonUtils.add(comment);
            commonDAO.add(sql);
            return  1;
        }
    }
}
