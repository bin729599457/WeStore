package com.westore.model;

public class T_B_Discount_Type {

    private String id;
    private float max_money;
    private float discount;

    public T_B_Discount_Type() {
    }

    public T_B_Discount_Type(String id, float max_money, float discount) {
        this.id = id;
        this.max_money = max_money;
        this.discount = discount;
    }

    public T_B_Discount_Type(float max_money, float discount) {
        this.max_money = max_money;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getMax_money() {
        return max_money;
    }

    public void setMax_money(float max_money) {
        this.max_money = max_money;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "T_B_Discount_Type{" +
                "id='" + id + '\'' +
                ", max_money=" + max_money +
                ", discount=" + discount +
                '}';
    }
}
