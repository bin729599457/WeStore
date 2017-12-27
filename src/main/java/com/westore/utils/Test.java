package com.westore.utils;

public class Test {

    public static void main(String[] args) {
/**
 *      str＝str.substring(int beginIndex);截取掉str从首字母起长度为beginIndex的字符串，将剩余字符串赋值给str；
        str＝str.substring(int beginIndex，int endIndex);截取str中从beginIndex开始至endIndex结束时的字符串，并将其赋值给str;
 */
/*        String str="this is my original string";
        String toDelete=" original";
        if(str.startsWith(toDelete))
            str=str.substring(toDelete.length());
        else
            if(str.endsWith(toDelete))
                str=str.substring(0, str.length()-toDelete.length());
            else {
                int index=str.indexOf(toDelete);
                if(index!=-1) {
                    String str1=str.substring(0, index);
                    String str2=str.substring(index+toDelete.length());
                    str=str1+str2;
                    }
                else
                    System.out.println("string /"+""+toDelete+"/"+" not found");
            }
        System.out.println(str);*/

        /**
         * 联系substring
         */
        String Str = new String("www.runoob.com");

        System.out.print("返回值 :" );
        System.out.println(Str.substring(4) );

        System.out.print("返回值 :" );
        System.out.println(Str.substring(4, 10) );
    }
}
