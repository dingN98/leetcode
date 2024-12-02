package cn.njust.leetcode.NiuKe.动态规划;

public class BM64 {

    public int minCostClimbingStairs (int[] cost) {
        // write code here
        // 定义dp为站在该台阶上需要的代价

        int len = cost.length;
        if (len == 1 || len == 2) {
            return 0;
        }
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = (Math.min(dp[i - 1]+cost[i-1], dp[i - 2]+cost[i-2]));
        }
        return dp[len];
    }

    public static void main(String[] args) {

    }
}
