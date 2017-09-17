package com.westore.model;

public class T_B_Goods {

    private int id;
    private String goods_name;
    private int goods_type_id;
    private String goods_descript;
    private String goods_price;
    private String goods_images_json;

    public T_B_Goods() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getGoods_type_id() {
        return goods_type_id;
    }

    public void setGoods_type_id(int goods_type_id) {
        this.goods_type_id = goods_type_id;
    }

    public String getGoods_descript() {
        return goods_descript;
    }

    public void setGoods_descript(String goods_descript) {
        this.goods_descript = goods_descript;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_images_json() {
        return goods_images_json;
    }

    public void setGoods_images_json(String goods_images_json) {
        this.goods_images_json = goods_images_json;
    }
}
