package cn.njust.leetcode.DP;

public class Lee309 {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        int[][] dp = new int[len][4];
        // dp[i][j]  表示第 i 天做完操作 之后的状态是 j
        // j 有3种状态： 初始、买入、冷冻期
        // 三种操作： 无操作、买入操作、卖出操作


        // 上午状态	操作	下午状态
        //初始	买入	买入
        //买入	无	买入
        //买入	卖出	冷冻期
        //冷冻期	无	初始
        //初始	无	初始

        dp[0][1] = -prices[0];

        for(int i=1;i<len;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2] = dp[i-1][1]+prices[i];
        }

        return Math.max(dp[len-1][0],dp[len-1][2]);
    }

    public static void main(String[] args) {
//        int[] prices = {1,2,3,0,2};
        int[] prices = {2,1};
        int res = new Lee309().maxProfit(prices);
        System.out.println(res);
    }
}
