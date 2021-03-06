package com.westore.model;

import javax.persistence.Column;

public class T_B_User {

    @Column(name = "ID")
    private String id;
    @Column(name = "USER_ID")
    private String user_id;
    @Column(name = "USER_IMG")
    private String user_img;
    @Column(name = "USER_NAME")
    private String user_name;
    @Column(name = "USER_PHONE")
    private String user_phone;
    @Column(name = "USER_PASSWORD")
    private String user_password;
    @Column(name = "USER_MONEY")
    private float user_money;

    public T_B_User() {
    }

    public T_B_User(String id, String user_id, String user_img, String user_name, String user_phone, String user_password, float user_money) {
        this.id = id;
        this.user_id = user_id;
        this.user_img = user_img;
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_password = user_password;
        this.user_money = user_money;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public float getUser_money() {
        return user_money;
    }

    public void setUser_money(float user_money) {
        this.user_money = user_money;
    }

    @Override
    public String toString() {
        return "T_B_User{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_img='" + user_img + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_phone=" + user_phone +
                ", user_password=" + user_password +
                ", user_money=" + user_money +
                '}';
    }
}
