package com.westore.model;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class QueueList{

    private int size;
    private int max;
    private List<String> list= new ArrayList<String>();

    public int getSize() {
        return list.size();
    }


    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(String arrayString) {
        arrayString = arrayString.replace("[","").replace("]","").replace(" ","");
        String[] array = arrayString.split(",");
        int length = array.length;
        for(int i = 0;i < length;i++){
            list.add(array[i]);
        }
    }


    public void append(String item){
        if(list.size() == 0){
            list.add(item);
        }
        else{
            if(list.size() < max){
                list.add(item);
            }
            else{
                List<String> temp= new ArrayList<String>();
                int size = list.size();
                for(int i = 0;i < max-1;i++){
                    temp.add(list.get(size-max+i+1));
                }
                temp.add(item);
                list = temp;
            }
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
