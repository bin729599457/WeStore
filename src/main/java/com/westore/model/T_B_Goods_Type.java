package com.westore.model;

import javax.persistence.Column;

public class T_B_Goods_Type {

    @Column(name = "iD")
    private String id;
    @Column(name = "GOODS_TYPE_NAME")
    private String goods_type_name;

    public T_B_Goods_Type() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoods_type_name() {
        return goods_type_name;
    }

    public void setGoods_type_name(String goods_type_name) {
        this.goods_type_name = goods_type_name;
    }

    @Override
    public String toString() {
        return "T_B_Goods_Type{" +
                "id='" + id + '\'' +
                ", goods_type_name='" + goods_type_name + '\'' +
                '}';
    }
}
