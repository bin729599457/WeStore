package com.westore.dao;

import com.westore.model.T_B_Comment;

import java.util.List;

public interface CommentDAO {

    public List<T_B_Comment> getBookComment(String goods_id);

    public int getBookCommentNum(String goods_id);

    public float getBookCommentAvg(String goods_id);

}
