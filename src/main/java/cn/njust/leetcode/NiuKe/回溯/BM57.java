package cn.njust.leetcode.NiuKe.回溯;

public class BM57 {

    // BM57 岛屿数量
    // 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
    //岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
    public int solve (char[][] grid) {
        // write code here
        // 我的基本思路是传染法
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    infect(grid,i,j);
                    res++;
                }
            }
        }
        return res;

    }

    public void infect(char[][] grid,int x,int y){
        int rows = grid.length;
        int cols = grid[0].length;
        if(x<0 || y<0 || x>=rows || y>=cols  || grid[x][y]!='1'){
            return;
        }
        grid[x][y] = '2';

        infect(grid,x+1,y);
        infect(grid,x-1,y);
        infect(grid,x,y+1);
        infect(grid,x,y-1);
    }

    public static void main(String[] args) {

    }
}
