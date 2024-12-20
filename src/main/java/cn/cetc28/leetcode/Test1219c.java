package cn.cetc28.leetcode;

import sun.java2d.windows.GDIRenderer;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/19 20:52
 * 064 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 */
public class Test1219c {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                }else if(i==0){
                    dp[i][j] = dp[i][j-1]+grid[i][j];
                }else if(j==0){
                    dp[i][j] = dp[i-1][j]+grid[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+ grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];


    }

    public static void main(String[] args) {

    }
}
