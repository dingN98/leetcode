package cn.njust.leetcode.QiuZhao.meituan0806;

import java.util.Scanner;

public class Exam2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i] = scanner.nextInt();
        }
        int minV = Integer.MAX_VALUE;
        int idx = -1;
        int sumA = 0;
        int sumB = 0;
        while(idx<=len){
            for(int i=0;i<idx;i++){
                if(nums[i]>=0){
                    sumA++;
                }
            }
            for(int i=idx+1;i<len;i++){
                if(nums[i]<=0){
                    sumB++;
                }
            }
            minV = Math.min(minV,sumA+sumB);
            sumA = 0;
            sumB = 0;
            idx++;
        }
        System.out.println(minV);

    }
}
