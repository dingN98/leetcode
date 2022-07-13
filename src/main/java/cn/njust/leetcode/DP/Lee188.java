package cn.njust.leetcode.DP;

public class Lee188 {
    public int maxProfit(int k, int[] prices) {

        int len = prices.length;

        if(len==0){
            return 0;
        }
        int res = 0;

        int[][] dp = new int[len][2*k+1];
        // dp[i][j] 表示第i天的第j个状态的利润
        // 状态：  初始、第一次买入、第一次卖出、第二次买入、第二次卖出、。。。
        // 操作： 无操作、买入操作、卖出操作

        for(int i=0;i<k;i++){
            dp[0][2*i+1] = -prices[0];

        }
        for(int i=1;i<len;i++){
            dp[i][0] = dp[i-1][0];
            for(int j=1;j<=k;j++){
                dp[i][2*j-1] = Math.max(dp[i-1][2*j-1],dp[i-1][2*j-2]-prices[i]);
                dp[i][2*j] = Math.max(dp[i-1][2*j],dp[i-1][2*j-1]+prices[i]);

                res = Math.max(res,dp[i][2*j]);
            }
//            // k=1
//            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
//            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
//            // k=2
//            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
//            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
//            // k=3
//            dp[i][5] = Math.max(dp[i-1][5],dp[i-1][4]-prices[i]);
//            dp[i][6] = Math.max(dp[i-1][6],dp[i-1][5]+prices[i]);

        }
        return res;
    }

    public static void main(String[] args) {
//        int[] prices = {2,4,1};
//        int[] prices = {3,2,6,5,0,3};
        int[] prices = {};
        int res = new Lee188().maxProfit(2,prices);
        System.out.println(res);
    }

}
