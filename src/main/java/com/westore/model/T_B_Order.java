package com.westore.model;

import java.util.Date;

public class T_B_Order {

    private String id;
    private String user_id;
    private float total_money;
    private String order_date;
    private int order_state;

    public T_B_Order() {
    }

    public T_B_Order(String id, String user_id, float total_money, String order_date, int order_state) {
        this.id = id;
        this.user_id = user_id;
        this.total_money = total_money;
        this.order_date = order_date;
        this.order_state = order_state;
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

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

}
