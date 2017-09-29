package com.westore.service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.westore.dao.CommentDAO;
import com.westore.model.T_B_Comment;
import com.westore.model.T_B_Location;
import com.westore.service.CommentService;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("commentService")
public class CommentServiceImpl implements CommentService{


    @Resource
    private CommentDAO commentDAO;


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
}
