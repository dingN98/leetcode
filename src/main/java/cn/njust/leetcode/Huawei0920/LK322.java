package cn.njust.leetcode.Huawei0920;

import java.util.ArrayList;
import java.util.Arrays;

public class LK322 {

    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示金额为 i 时 需要的最少硬币数量
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                int coin = coins[j];
                if(i>=coin && dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = {2};
//        int[] nums = {1,2,5};
        int res = new LK322().coinChange(nums,3);
        System.out.println(res);
    }
}
