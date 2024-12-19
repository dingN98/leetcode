package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/19 20:40
 */
public class Test1219b {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[0][0] = obstacleGrid[0][0]==1?0:1;
                }else if(i==0){
                    dp[i][j] = obstacleGrid[i][j]==1?0:dp[i][j-1];
                }else if(j==0){
                    dp[i][j] = obstacleGrid[i][j]==1?0:dp[i-1][j];
                }else{
                    dp[i][j] = obstacleGrid[i][j]==1?0:dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];

    }

    public static void main(String[] args) {

    }
}
