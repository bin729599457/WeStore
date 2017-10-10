package com.westore.model;

public class T_B_Goods_Second_Type {

    private String id;
    private String goods_second_type_name;
    private String goods_type_id;
    private String img;

    public T_B_Goods_Second_Type(String id, String goods_second_type_name, String goods_type_id, String img) {
        this.id = id;
        this.goods_second_type_name = goods_second_type_name;
        this.goods_type_id = goods_type_id;
        this.img = img;
    }

    public T_B_Goods_Second_Type() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoods_second_type_name() {
        return goods_second_type_name;
    }

    public void setGoods_second_type_name(String goods_second_type_name) {
        this.goods_second_type_name = goods_second_type_name;
    }

    public String getGoods_type_id() {
        return goods_type_id;
    }

    public void setGoods_type_id(String goods_type_id) {
        this.goods_type_id = goods_type_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "T_B_Goods_Second_Type{" +
                "id='" + id + '\'' +
                ", goods_second_type_name='" + goods_second_type_name + '\'' +
                ", goods_type_id='" + goods_type_id + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
