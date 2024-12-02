package cn.njust.leetcode.Huawei0920;

public class LK64_2 {

    int res = Integer.MAX_VALUE;

    // 64. 最小路径和
    // 方法2  dp  dfs会超时
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        int sum = 0;
        for(int i=0;i<rows;i++){
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for(int j=0;j<cols;j++){
            sum += grid[0][j];
            dp[0][j] = sum;
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[rows-1][cols-1];

    }



    public static void main(String[] args) {

    }
}
