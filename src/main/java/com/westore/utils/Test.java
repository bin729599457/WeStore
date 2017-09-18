package com.westore.utils;

public class Test {
    public static void main(String[] args) {
        long l=new CustomUUID(129).generate();
        String str= Long.toString(l);
        System.out.println(str);
    }
}
//1819222459275019265
//1819222621904962560
//1819222768697213955
//1819223093520893960