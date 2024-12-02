package cn.njust.leetcode.Huawei0920;

public class LK64 {

    int res = Integer.MAX_VALUE;

    // 64. 最小路径和
    public int minPathSum(int[][] grid) {
        dfs(grid,0,0,0);
        return res;

    }

    public void dfs(int[][] grid,int x,int y,int path){
        int rows = grid.length;
        int cols = grid[0].length;
        if(x<0 || y<0 || x>=rows || y>=cols){
            return;
        }
        if(x==rows-1 && y==cols-1){
            res = Math.min(res,path+grid[rows-1][cols-1]);
            return;
        }
        int num = grid[x][y];
        dfs(grid,x+1,y,path+num);
        dfs(grid,x,y+1,path+num);
    }

    public static void main(String[] args) {

    }
}
