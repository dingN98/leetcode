package cn.njust.leetcode.QiuZhao.weiRuan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exam3_2 {

    int solution(int A[], int X, int Y) {

        int minCost = Integer.MAX_VALUE;
        ArrayList<Integer>[] nums = new ArrayList[Y];
        for(int i=0;i<nums.length;i++){
            nums[i] = new ArrayList<>();
        }
        for(int i=0;i<A.length;i++){
            nums[i%Y].add(A[i]);
        }

        for(int i=0;i<nums.length;i++){
            minCost = Math.min(minCost,getSumMin(nums[i],X));
        }
        return minCost;
    }

    public int getSumMin(ArrayList<Integer> nums,int k){
        if(nums.size()<k){
            return Integer.MAX_VALUE;
        }
        int sumMin = 0;
        for(int i=0;i<k;i++){
            sumMin += nums.get(i);
        }
        int tmp = sumMin;
        for(int i=k;i<nums.size();i++){
            tmp = tmp+nums.get(i)-nums.get(i-k);
            sumMin = Math.min(sumMin,tmp);
        }
        return sumMin;
    }

    public static void main(String[] args) {
//        int[] A = {4,2,3,7};
//        int[] A = {10,3,4,7};
        int[] A = {4,2,5,4,3,5,1,4,2,7};
        int res = new Exam3_2().solution(A,3,2);
        System.out.println(res);

    }
}
