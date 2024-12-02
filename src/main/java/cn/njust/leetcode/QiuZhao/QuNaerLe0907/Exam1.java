package cn.njust.leetcode.QiuZhao.QuNaerLe0907;

public class Exam1 {

    public int maxScore (int energy, int[][] actions) {
        // write code here
        int n = actions.length;
        int[][] dp = new int[n+1][energy+1];
//        for(int j=0;j<energy+1;j++){
//            dp[0][j] = 0;
//        }
//        for(int i=0;i<n+1;i++){
//            dp[i][0] = 0;
//        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=energy;j++){
                int max = dp[i-1][j];
                if(j-actions[i-1][0]>=0){
                    max = Math.max(max,actions[i-1][1]+dp[i-1][j-actions[i-1][0]]);
                }
                dp[i][j] = max;
            }
        }
        int max = 0;
        for(int j=1;j<energy;j++){
            max = Math.max(max,dp[n][j]);
        }
        return max;


    }
}
