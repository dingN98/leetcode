package cn.njust.leetcode.QiuZhao.weiRuan;

import java.util.Arrays;

public class Exam1 {

    int res = 0;

    public int solution(int[] A) {

        int maxCnt = 0;
        double target = 0;
        double[] weights = new double[A.length];

        for(int i=0;i<A.length;i++){
            target += A[i];
            maxCnt += (A[i]==0?0:1);
            weights[i] = 1.0;
        }

        res = maxCnt;

        search(A,target/2,weights,maxCnt,0);

        return res;

    }

    public void search(int[] nums,double target,double[] weights,int maxCnt,int k){
        double sum  = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i]*weights[i];
        }
        if(sum<=target){
            res = Math.min(res,k);
            for(int i=0;i<weights.length;i++){
                System.out.print(weights[i]+" ");
            }
            System.out.println();
            return;
        }
        if(k>maxCnt){
            return;
        }
        for(int i=0;i<weights.length;i++){
            if(nums[i]!=0){
                double w = weights[i];
                weights[i] = w/2;
                search(nums,target,weights,maxCnt,k+1);
                weights[i] = w;
            }

        }
    }



    public static void main(String[] args) {

//        int[] nums = {5,19,8,1};
//        int[] nums = {10,10};
        int[] nums = {3,0,5};
        int res = new Exam1().solution(nums);
        System.out.println(res);



    }
}
