package cn.njust.leetcode.QiuZhao.RongYao0902;

public class Exam3 {

    public int numIslands (char[][] grid) {
        // write code here
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j]){
                    if(grid[i][j]=='1'){
                        res++;
                        dfs(grid,i,j,visited);
                    }
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid,int x,int y,boolean[][] visited){
        if(x<0 || x>=grid.length || y<0 || y>=grid[x].length || visited[x][y]){
            return;
        }
        visited[x][y] = true;
        if(grid[x][y]=='0'){
            return;
        }
        dfs(grid,x+1,y,visited);
        dfs(grid,x-1,y,visited);
        dfs(grid,x,y+1,visited);
        dfs(grid,x,y-1,visited);
//        visited[x][y] = false;
    }
}
