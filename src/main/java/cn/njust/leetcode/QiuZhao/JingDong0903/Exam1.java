package cn.njust.leetcode.QiuZhao.JingDong0903;

import java.util.Scanner;

public class Exam1 {

    public static int fun(int[] nums){
        int maxV = 0;
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            int tmp = nums[i];
            if(tmp>maxV){
                maxV = tmp;
                cnt = 1;
            }else if(tmp==maxV){
                cnt++;
            }
        }
        return nums.length-cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i] = sc.nextInt();
        }
        int res = fun(nums);
        System.out.println(res);

    }
}
