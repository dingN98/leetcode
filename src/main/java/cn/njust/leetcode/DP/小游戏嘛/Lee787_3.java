package cn.njust.leetcode.DP.小游戏嘛;

import java.util.Arrays;

public class Lee787_3 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int MAX_VAL = Integer.MAX_VALUE;

        // dp[i][j] 表示 从  src  到达 i (还有 j 次转机机会) , 需要的 price
        int[][] dp = new int[n][1+k];

        // 初始化
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],MAX_VAL);
        }
        for(int i=0;i<=k;i++){
            dp[src][i] = 0;
        }
        for(int[] flight:flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            if(from==src){
                dp[to][0] = price;
            }
        }

        // 选择转机 或者 不转机
        for(int i=1;i<=k;i++){
            for(int[] flight:flights){
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                // 从 src 经由 from 到 to 的前提是   src到from 之间可以直达
                if(dp[from][i-1]!=MAX_VAL){
                    dp[to][i] = Math.min(dp[to][i],dp[from][i-1]+price);
                }

            }
        }

        return dp[dst][k]==MAX_VAL?-1:dp[dst][k];
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int k = 1;
        int res = new Lee787_3().findCheapestPrice(n,flights,0,2,k);
        System.out.println(res);
    }
}
