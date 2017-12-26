package com.westore.utils;

public class Test {

    public static void main(String[] args) {

        String str="this is my original string";
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
        System.out.println(str);
    }
}
