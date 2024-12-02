package cn.njust.leetcode.LianTong0923;

import java.util.Arrays;
import java.util.Scanner;

public class Exam1 {

    public static int getThirdNum(int[] nums){
        Arrays.sort(nums);
        // 去重
        int lastNum = Integer.MAX_VALUE;
        int k = 3;
        for(int i=nums.length-1;i>=0;){
            int num = nums[i];
            if(num==lastNum){
                i--;
            }else{
                lastNum = num;
                k--;
                if(k==0){
                    return num;
                }
                i--;
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String string = cin.nextLine();
        String[] strArr = string.split(" ");
        int[] arr = new int[strArr.length];
        for(int i=0;i<strArr.length;i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        System.out.println(getThirdNum(arr));
    }

}
