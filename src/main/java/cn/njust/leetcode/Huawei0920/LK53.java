package cn.njust.leetcode.Huawei0920;

public class LK53 {

    // 53. 最大子数组和
    public int maxSubArray(int[] nums) {
        // 简单DP
        // dp[i] 表示以nums[i]结尾的最大子数组和
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxV = nums[0];
        for(int i=1;i<len;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            maxV = Math.max(maxV,dp[i]);
        }
        return maxV;
    }

    public static void main(String[] args) {

    }

}
