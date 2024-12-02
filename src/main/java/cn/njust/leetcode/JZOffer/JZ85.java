package cn.njust.leetcode.JZOffer;

import java.util.Arrays;
import java.util.Map;

public class JZ85 {

    // 连续子数组的最大和(二)
    // 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，找到一个具有最大和的连续子数组。
    //1.子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
    //2.如果存在多个最大和的连续子数组，那么返回其中长度最长的，该题数据保证这个最长的只存在一个
    //3.该题定义的子数组的最小长度为1，不存在为空的子数组，即不存在[]是某个数组的子数组
    //4.返回的数组不计入空间复杂度计算
    public int[] FindGreatestSumOfSubArray (int[] nums) {
        // write code here
        int len = nums.length;
        if(len==1){
            return nums;
        }

        int[] dp = new int[len];
        int[] leftIndex = new int[len];
        dp[0] = nums[0];
        leftIndex[0] = 0;
        int resIndex = 0;
        for(int i=1;i<len;i++){
            int val1 = nums[i];
            int val2 = nums[i]+dp[i-1];
            if(val1>val2){
                dp[i] = val1;
                leftIndex[i] = i;
            }else{
                dp[i] = val2;
                leftIndex[i] = leftIndex[i-1];
            }
            if(dp[i]>=dp[resIndex]){
                if(dp[i]>dp[resIndex]){
                    resIndex = i;
                }else{
                    int len1 = resIndex-leftIndex[resIndex];
                    int len2 = i - leftIndex[i];
                    if(len2>len1){
                        resIndex = i;
                    }
                }
            }
        }
//        System.out.println(dp[resIndex]);
        return Arrays.copyOfRange(nums,leftIndex[resIndex],resIndex+1);
    }

    public static void main(String[] args) {

//        int[] nums = {-1,1,2,1};
        int[] nums = {-1,3,2,1,-2,-2,-3,0,3,2,1,-1};
        int[] res = new JZ85().FindGreatestSumOfSubArray(nums);
        for(int tmp:res){
            System.out.print(tmp+" ");
        }

    }
}
