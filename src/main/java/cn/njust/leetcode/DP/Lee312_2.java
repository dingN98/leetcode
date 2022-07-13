package cn.njust.leetcode.DP;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Lee312_2 {

    public int maxCoins(int[] nums) {

        // 区间法
        // dp[i][j] 表示开区间  (i,j)内的最大收益  区间内的k是最后一个戳破的气球
        // 因为是开区间  所以 气球 nums  两边各自补上一个  1
        int len = nums.length;

        int[] p = new int[len+2];
        p[0] = 1;
        p[len+1] = 1;
        for(int i=0;i<len;i++){
            p[i+1] = nums[i];
        }
        len = len + 2;

        int[][] dp = new int[len][len];
        for(int i= len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                for(int k=i+1;k<j;k++){
                    dp[i][j] = Math.max(dp[i][j],dp[i][k]+dp[k][j]+p[i]*p[k]*p[j]);
                }
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
//        int[] nums = {3,1,5,8};
        int[] nums = {1,5};
        int res = new Lee312_2().maxCoins(nums);
        System.out.println(res);
    }

}
