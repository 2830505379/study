package com.star.study.algorithm.array;

/**
 * Created by hxx9048 on 2017/6/23.
 */
public class MaxSubSeqSum {

//    穷举法
    private static int test1(int[] data){
        int max=0;
        for(int i=0;i<data.length;i++){
            int sum=0;
            for(int j=i;j<data.length;j++){
                sum+=data[j];
                if(sum>max){
                    max=sum;
                    System.out.println("max:"+max+" begin:"+i+" end:"+j);
                }
            }
        }
        return max;
    }

//    分治法
    private static int test2(int[] data,int left,int right){

        if(left==right){
            if(data[left]>0){
                return data[left];
            }else {
                return 0;
            }
        }

        int middle=(left+right)/2;

        int maxLeftSum=test2(data,left,middle);
        int maxRightSum=test2(data,middle+1,right);

        int maxLeftBorderSum=0,maxRightBorderSum=0;
        int maxLeftBorder=0,maxRightBorer=0;

        for(int i=middle;i>=left;i--){
            maxLeftBorder+=data[i];
            if(maxLeftBorder>maxLeftBorderSum){
                maxLeftBorderSum=maxLeftBorder;
            }
        }

        for(int i=middle+1;i<=right;i++){
            maxRightBorer+=data[i];
            if(maxRightBorer>maxRightBorderSum){
                maxRightBorderSum=maxRightBorer;
            }
        }

        return max(maxLeftSum,maxRightSum,maxRightBorderSum+maxLeftBorderSum);
    }

//    动态规划
    private static int test3(int[] data){

        int maxSum=0,thisSum=0;

        for(int i=0;i<data.length;i++){
            thisSum+=data[i];
            if(thisSum>maxSum){
                maxSum=thisSum;
            }
            if(thisSum<0){
                thisSum=0;
            }
        }

        return maxSum;

    }

    public static void main(String[] args) {
        int[] data={3,-1,2,5,-3,4,-6,-7,1,8,-3,5,9,11,23,-32,23,-19};
        System.out.println("test1:"+test1(data));
        System.out.println("test2:"+test2(data,0,data.length-1));
        System.out.println("test3:"+test3(data));
    }

    private static int max(int maxLeftSum,int maxRightSum,int maxMiddleSum){
        return maxLeftSum>maxRightSum?
                (maxLeftSum>maxMiddleSum?maxLeftSum:maxMiddleSum)
                :(maxRightSum>maxMiddleSum?maxRightSum:maxMiddleSum);

    }

}
