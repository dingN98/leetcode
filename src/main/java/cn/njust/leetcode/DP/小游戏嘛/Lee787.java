package cn.njust.leetcode.DP.小游戏嘛;

import java.util.HashMap;

public class Lee787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int MAX_VAL = Integer.MAX_VALUE;

        // 表示从 i 站 到 j 站  最多经过 k 次转机  需要的price
        int[][][] dp = new int[n][n][k+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int m=0;m<=k;m++){
                    dp[i][j][m] = MAX_VAL;
                }
            }
        }

        for(int i=0;i<flights.length;i++){
            int x = flights[i][0];
            int y = flights[i][1];
            int z = flights[i][2];
            dp[x][y][0] = z;
        }

        for(int m=1;m<=k;m++){
            for(int i=0;i<n;i++){
                if(i==src || i==dst) {
                    continue;
                }
                if(dp[src][i][m-1]!=MAX_VAL && dp[i][dst][m-1]!=MAX_VAL){
                    // 可以转机
                    dp[src][dst][m] = Math.min(dp[src][dst][m-1],dp[src][i][m-1]+dp[i][dst][m-1]);
                }else{
                    dp[src][dst][m] = dp[src][dst][m-1];
                }
            }
        }

        return dp[src][dst][k];
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int k = 1;
        int res = new Lee787().findCheapestPrice(n,flights,0,2,k);
        System.out.println(res);
    }
}
