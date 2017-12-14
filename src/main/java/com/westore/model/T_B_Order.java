package com.westore.model;

import javax.persistence.Column;
import java.util.Date;

public class T_B_Order {

    @Column(name = "ID")
    private String id;
    @Column(name = "USER_ID")
    private String user_id;
    @Column(name = "TOTAL_MONEY")
    private float total_money;
    @Column(name = "ORDER_DATE")
    private String order_date;
    @Column(name = "ORDER_DATE")
    private int order_state;
    @Column(name = "ORDER_DATE")
    private String location_id;

    public T_B_Order() {
    }

    public T_B_Order(String id, String user_id, float total_money, String order_date, int order_state, String location_id) {
        this.id = id;
        this.user_id = user_id;
        this.total_money = total_money;
        this.order_date = order_date;
        this.order_state = order_state;
        this.location_id = location_id;
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

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }
}
