package com.westore.model;

public class T_B_Discount {

    private String id;
    private String user_id;
    private String discount_type;
    private int is_used;

    public T_B_Discount(String id, String user_id, String discount_type, int is_used) {
        this.id = id;
        this.user_id = user_id;
        this.discount_type = discount_type;
        this.is_used = is_used;
    }

    public T_B_Discount() {
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

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public int getIs_used() {
        return is_used;
    }

    public void setIs_used(int is_used) {
        this.is_used = is_used;
    }

    @Override
    public String toString() {
        return "T_B_Discount{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", discount_type='" + discount_type + '\'' +
                ", is_used=" + is_used +
                '}';
    }
}
