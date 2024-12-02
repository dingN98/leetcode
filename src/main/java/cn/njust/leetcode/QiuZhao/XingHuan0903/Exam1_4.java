package cn.njust.leetcode.QiuZhao.XingHuan0903;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Exam1_4 {

    public static int fun(int[][] nums){
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });
        for(int i=0;i<n;i++){
            if(i>0 && nums[i][0]==nums[i-1][0]){
                continue;
            }
            if(i>0 && nums[i][0]>nums[i-1][0] &&nums[i][1]<=nums[i-1][1]){
                continue;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] nums = new int[len][2];
        for(int i=0;i<len;i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        int res = fun(nums);
        System.out.println(res);

    }
}
