package cn.njust.leetcode.JZOffer;

public class JZ42 {

    // 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
    public int FindGreatestSumOfSubArray(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];
        // dp[i] 表示以 nums[i] 结尾的连续子数组的最大和
        if(len==1){
            return nums[0];
        }
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for(int i=1;i<len;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    public static void main(String[] args) {

//        int[] nums = {1,-2,3,10,-4,7,2,-5};
        int[] nums = {-1,1,2,1};
        int res = new JZ42().FindGreatestSumOfSubArray(nums);
        System.out.println(res);

    }
}
