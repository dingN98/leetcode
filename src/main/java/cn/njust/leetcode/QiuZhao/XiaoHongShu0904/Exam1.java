package cn.njust.leetcode.QiuZhao.XiaoHongShu0904;

import java.util.Scanner;

public class Exam1 {

    public static int fun(int n,int[] nums,int m,int k){
        int T = 2*nums.length;
        int index = (k-1)%T;
        if(index<nums.length){
            return nums[index];
        }
        return nums[T-index-1];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }

        int res = fun(n,nums,m,k);
        System.out.println(res);

    }
}
