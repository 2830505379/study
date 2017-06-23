package com.star.study.algorithm.sort;
/**
 * Created by hxx9048 on 2017/6/22.
 */
public class InsertSort {

    public static void sort(int[] data){

        for(int i=1;i<100;i++){
            int key=data[i];
            int j=i-1;
            while (j>=0&&data[j]>key){
                data[j+1]=data[i];
                j--;
            }
            data[j+1]=key;
        }
    }
}
