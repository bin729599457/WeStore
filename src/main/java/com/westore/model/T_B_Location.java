package com.westore.model;

import org.springframework.beans.factory.annotation.Autowired;

public class T_B_Location {

    private String id;
    private String user_id;
    private String user_name;
    private String user_location;
    private String user_phone;
    private int is_default;

    public T_B_Location() {
    }

    public T_B_Location(String id, String user_id, String user_name, String user_location, String user_phone, int is_default) {
        this.id = id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_location = user_location;
        this.user_phone = user_phone;
        this.is_default = is_default;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_location() {
        return user_location;
    }

    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }

    @Override
    public String toString() {
        return "T_B_Location{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_location='" + user_location + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", is_default=" + is_default +
                '}';
    }
}
