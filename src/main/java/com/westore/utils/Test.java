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
/*
        Map map=new TreeMap();
        map.put(1, "a");
        map.put(6, "b");
        map.put(2, "c");
        map.put(5, "d");
        map.put(6,"f");


        Set entries = map.entrySet( );
        if(entries != null) {
            Iterator iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
//                System.out.println(key.toString()+""+value.toString());
            }
        }*/


        System.out.println(fun(30));
    }


   public static int fun(int i){

     if(i<=0)
       return 0;
    else if(i<=2)
        return 1;
    else
      return fun(i-1)+fun(i-2);
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
    //选择排序
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
    //插入排序
    public void insertSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]){
                for(int j = i; j >= 1; j--){  //从当前位置开始向前寻找
                    if(nums[j] < nums[j - 1]){  //顺序出问题就交换
                        int temp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = temp;
                    }else{  //因为之前的数组元素已排序，无需再进行比较
                        break;
                    }
                }
            }
        }
    }
    //冒泡排序
    public void bubbleSort(int[] a){

        int temp=0;
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    //快速排序
    public static void quickSort(int[] arr){
        qsort(arr, 0, arr.length-1);
    }
    private static void qsort(int[] arr, int low, int high){
        if (low < high){
            int pivot=partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot-1);                   //递归排序左子数组
            qsort(arr, pivot+1, high);                  //递归排序右子数组
        }
    }
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //枢轴记录
        while (low<high){
            while (low<high && arr[high]>=pivot) --high;
            arr[low]=arr[high];             //交换比枢轴小的记录到左端
            while (low<high && arr[low]<=pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }
}
