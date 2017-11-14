package com.westore.utils;

import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.CommomService;

import javax.annotation.Resource;
import java.util.*;

public class Test {

    private int testNum=0;
    private String testStr="hello";

    public static void main(String[] args) {

        Map map=new HashMap();
        Set entries = map.entrySet( );
        if(entries != null) {
            Iterator iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
            }
        }
    }

    public static void selectSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;
        int minIndex = 0;
        for(int i=0; i<arr.length-1; i++) { //只需要比较n-1次
            minIndex = i;
            for(int j=i+1; j<arr.length; j++) { //从i+1开始比较，因为minIndex默认为i了，i就没必要比了。
                if(arr[j] <arr[minIndex]) {
                    minIndex = j;
                }
            }

            if(minIndex != i) { //如果minIndex不为i，说明找到了更小的值，交换之。
                swap(arr, i, minIndex);
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void chooseSort(int[] nums){
        int min;  //升序排序，记录每趟最小值的下标
        for(int i = 0; i < nums.length; i++){
            min = i;  //初始化为本次排序的第一个数
            for(int j = i + 1; j < nums.length; j++){
                if(nums[min] > nums[j]){  //顺序有问题，更新min即可
                    min = j;
                }
            }
            if(min != i){  //发现更新，交换操作
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }


}
