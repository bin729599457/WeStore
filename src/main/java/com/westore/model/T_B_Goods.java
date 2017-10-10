package com.westore.model;

public class T_B_Goods {

    private String id;
    private String goods_title;
    private String goods_type_id;
    private String goods_descript;
    private String goods_price;
    private String goods_images;
    private int goods_nums;
    private int goods_sales_nums;
    private float goods_point;
    private String goods_author;
    private String goods_publisher;
    private String goods_second_type_id;
    private String is_discounted;

    @Override
    public String toString() {
        return "T_B_Goods{" +
                "id='" + id + '\'' +
                ", goods_title='" + goods_title + '\'' +
                ", goods_type_id='" + goods_type_id + '\'' +
                ", goods_descript='" + goods_descript + '\'' +
                ", goods_price='" + goods_price + '\'' +
                ", goods_images='" + goods_images + '\'' +
                ", goods_nums=" + goods_nums +
                ", goods_sales_nums=" + goods_sales_nums +
                ",goods_point="+goods_point+
                ",goods_author="+goods_author+
                ",goods_publisher="+goods_publisher+
                ",goods_second_type_id="+goods_second_type_id+
                ",is_discounted="+is_discounted+
                '}';
    }

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

    public String getGoods_images() {
        return goods_images;
    }

    public void setGoods_images(String goods_images) {
        this.goods_images = goods_images;
    }

    public String getGoods_type_id() {
        return goods_type_id;
    }

    public void setGoods_type_id(String goods_type_id) {
        this.goods_type_id = goods_type_id;
    }

    public float getGoods_point() {
        return goods_point;
    }

    public void setGoods_point(float goods_point) {
        this.goods_point = goods_point;
    }

    public String getGoods_author() {
        return goods_author;
    }

    public void setGoods_author(String goods_author) {
        this.goods_author = goods_author;
    }

    public String getGoods_publisher() {
        return goods_publisher;
    }

    public void setGoods_publisher(String goods_publisher) {
        this.goods_publisher = goods_publisher;
    }

    public String getGoods_second_type_id() {
        return goods_second_type_id;
    }

    public void setGoods_second_type_id(String goods_second_type_id) {
        this.goods_second_type_id = goods_second_type_id;
    }

    public String getIs_discounted() {
        return is_discounted;
    }

    public void setIs_discounted(String is_discounted) {
        this.is_discounted = is_discounted;
    }
}
