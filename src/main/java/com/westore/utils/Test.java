package com.westore.utils;

public class Test {
    public static void main(String[] args) {
        String str=new CustomUUID(128).generate();
        System.out.println(str);

    }

}
