package cn.njust.leetcode.Huawei0920;

public class LK200 {

    // 200. 岛屿数量
    public int numIslands(char[][] grid) {
        // 感染法计算
        int res = 0;
        int rows =grid.length;
        int cols = grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    infect(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    public void infect(char[][] grid,int x,int y){
        int rows =grid.length;
        int cols = grid[0].length;
        if(x< 0 || y<0 || x>=rows || y>=cols || grid[x][y]!='1'){
            return;
        }
        grid[x][y] = '2';
        infect(grid,x+1,y);
        infect(grid,x-1,y);
        infect(grid,x,y+1);
        infect(grid,x,y-1);
    }
}
