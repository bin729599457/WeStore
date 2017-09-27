package com.westore.model;

public class T_B_Cart {
    private String id;
    private String user_id;
    private T_B_Goods goods;
    private int num;


    public T_B_Cart() {

    }

    public T_B_Cart(String id, String user_id, T_B_Goods goods, int num) {
        this.id = id;
        this.user_id = user_id;
        this.goods = goods;
        this.num = num;
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

    public T_B_Goods getGoods() {
        return goods;
    }

    public void setGoods(T_B_Goods goods) {
        this.goods = goods;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "T_B_Cart{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", goods=" + goods +
                ", num=" + num +
                '}';
    }
}
