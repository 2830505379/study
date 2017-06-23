package com.star.study.algorithm.sort;

import java.util.Random;

/**
 * Created by hxx9048 on 2017/6/22.
 */
public class Sort {

    private static int[] res;

    private static void init(int n){
        res=new int[n];
        Random random=new Random();
        for(int i=0;i<n;i++)
            res[i]=random.nextInt(100000);
    }

    private static void show(){
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
            if((i+1)%10==0){
                System.out.print("\n");
            }
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        init(100);
//        InsertSort.sort(res);
        MergeSort.sort(res);
        show();
    }
}
