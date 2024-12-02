package cn.njust.leetcode.QiuZhao.YYW0823;

import java.util.Scanner;

public class Exam3_2 {

    public void solution(int[] nums){
        int len = nums.length;
        long min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        long sumI = 0;
        long sumJ = 0;
        for(int i=0;i<len;i++){
            sumI += nums[i];
            sumJ = 0;
            for(int j=len-1;j>i;j--){
                sumJ += nums[j];
                long tmp = Math.abs(sumI -sumJ);
                if(tmp<min){
                    min = tmp;
                    left = i;
                    right = j;
                }else if(tmp==min){
                    left = Math.min(left,i);
                    right = Math.max(right,j);
                }
            }
        }
        System.out.println(min+" "+(1+left)+" "+(1+right));
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i] = scanner.nextInt();
        }
        new Exam3_2().solution(nums);

    }
}
