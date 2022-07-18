package cn.njust.leetcode.DP.小游戏嘛;

public class Lee887 {

    public int superEggDrop(int k, int n) {

        int MAX_VAL = Integer.MAX_VALUE;

        // dp[i][j]表示当前拥有 i 个鸡蛋  还需要确定 j 层楼 需要的最小扔鸡蛋次数
        int[][] dp = new int[k+1][n+1];
        // 一个鸡蛋 遍历测试
        for(int i=0;i<=n;i++){
            dp[1][i] = i;
        }

        for(int i=2;i<=k;i++){
            for(int j=1;j<=n;j++){
                int tmp = MAX_VAL;
                for(int m=1;m<=j;m++){
                    // 在第m层扔鸡蛋  不碎  碎  取较大值（考虑最坏情况）
                    // m从1到j  dp[i][j]再取最小值
                    tmp = Math.min(tmp,1+Math.max(dp[i][m-1],dp[i-1][j-m]));
                }
                dp[i][j] = tmp;
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        int k = 2;
        int n = 6;
        int res = new Lee887().superEggDrop(k,n);
        System.out.println(res);
    }
}
