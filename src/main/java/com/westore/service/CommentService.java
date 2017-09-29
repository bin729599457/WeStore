package com.westore.service;

import com.github.pagehelper.PageInfo;
import com.westore.model.T_B_Comment;

public interface CommentService {


    public PageInfo<T_B_Comment> getBookComment(String goods_id,String pageNum,String pageSize);

    public int getBookCommentNum(String goods_id);

    public float getBookCommentAvg(String goods_id);

}
