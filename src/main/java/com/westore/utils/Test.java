package com.westore.utils;

public class Test {
    public static void main(String[] args) {
        String basestr = "123456";
        String str1 = DesUtil.encrypt(basestr);

        System.out.println("原始值: " + basestr);
        System.out.println("加密后: " + str1);
        System.out.println("解密后: " + DesUtil.decrypt(str1));
        System.out.println("为空时 is : " + DesUtil.decrypt(DesUtil.encrypt("")));
    }

}
