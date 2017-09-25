package com.westore.model;

public class T_B_Goods {

    private String id;
    private String goods_title;
    private String goods_type_name;
    private String goods_descript;
    private String goods_price;
    private String goods_images;
    private int goods_nums;
    private int goods_sales_nums;

    public T_B_Goods() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGoods_title() {
        return goods_title;
    }

    public void setGoods_title(String goods_title) {
        this.goods_title = goods_title;
    }

    public int getGoods_nums() {
        return goods_nums;
    }

    public void setGoods_nums(int goods_nums) {
        this.goods_nums = goods_nums;
    }

    public int getGoods_sales_nums() {
        return goods_sales_nums;
    }

    public void setGoods_sales_nums(int goods_sales_nums) {
        this.goods_sales_nums = goods_sales_nums;
    }

    public String getGoods_type_name() {
        return goods_type_name;
    }

    public void setGoods_type_name(String goods_type_name) {
        this.goods_type_name = goods_type_name;
    }

    public String getGoods_images() {
        return goods_images;
    }

    public void setGoods_images(String goods_images) {
        this.goods_images = goods_images;
    }
}
