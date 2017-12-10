package com.westore.utils;

public class SearchTest {

    public static void main(String[] args) {

    }

    /**
     * 二分查找普通实现。
     * @param srcArray 有序数组
     * @param key 查找元素
     * @return  不存在返回-1
     */
    public static int binSearch(int srcArray[], int key) {
        int mid = srcArray.length / 2;
        if (key == srcArray[mid]) {
            return mid;
        }

        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < srcArray[mid]) {
                end = mid - 1;
            } else if (key > srcArray[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    /**
     * 二分查找递归实现。
     * @param srcArray  有序数组
     * @param start 数组低地址下标
     * @param end   数组高地址下标
     * @param key  查找元素
     * @return 查找元素不存在返回-1
     */
    public static int binSearch(int srcArray[], int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }


    /**
    *@param  data   待查找的数组
    *@param  target 待查找的值
    *@return int    目标值在数组中的索引，如果没找到返回-1
    */
    public static int linearSearch(int[] data, int target) {

        int length = data.length;

        //从头遍历数组中的各个值，如果找到目标值就返回其索引
        for (int i = 0; i < length; i++) {
            if (data[i] == target) {
                return i;
            }
        }

        //代码能走到这一步就说明上面的循环遍历结束了也没找到目标值
        //即目标值不存在于数组中
        return -1;

    }


    /**
     * 斐波那契查找
     * @param table
     * @param keyWord
     * @return
     */

    public boolean fibonacciSearch(int[] table,int keyWord){
        //确定需要的斐波那契数
        int i = 0;
        while(getFibonacci(i)-1 == table.length){
            i++;
        }
        //开始查找
        int low = 0;
        int height = table.length-1;
        while(low<=height){
            int mid = low + getFibonacci(i-1);
            if(table[mid] == keyWord){
                return true;
            }else if(table[mid]>keyWord){
                height = mid-1;
                i--;
            }else if(table[mid]<keyWord){
                low = mid+1;
                i-=2;
            }
        }
        return false;
    }

    /**
     * 得到第n个斐波那契数
     * @return
     */
    public static int getFibonacci(int n){
        int res = 0;
        if(n == 0){
            res = 0;
        }else if(n == 1){
            res = 1;
        }else{
            int first = 0;
            int second = 1;
            for(int i = 2;i<=n;i++){
                res = first+second;
                first = second;
                second = res;
            }
        }
        return res;
    }

}


