package com.westore.model;

import java.util.Date;

public class T_B_Comment {

    private String id;
    private String goods_id;
    private String user_id;
    private int comment_point;
    private String comment_info;
    private Date comment_date;

    public T_B_Comment() {
    }

    public T_B_Comment(String id, String goods_id, String user_id, int comment_point, String comment_info, Date comment_date) {
        this.id = id;
        this.goods_id = goods_id;
        this.user_id = user_id;
        this.comment_point = comment_point;
        this.comment_info = comment_info;
        this.comment_date = comment_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getComment_point() {
        return comment_point;
    }

    public void setComment_point(int comment_point) {
        this.comment_point = comment_point;
    }

    public String getComment_info() {
        return comment_info;
    }

    public void setComment_info(String comment_info) {
        this.comment_info = comment_info;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    @Override
    public String toString() {
        return "T_B_Comment{" +
                "id='" + id + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", comment_point=" + comment_point +
                ", comment_info='" + comment_info + '\'' +
                ", comment_date=" + comment_date +
                '}';
    }
}
