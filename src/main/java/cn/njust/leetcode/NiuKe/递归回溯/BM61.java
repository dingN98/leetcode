package cn.njust.leetcode.NiuKe.递归回溯;

public class BM61 {
    // BM61 矩阵最长递增路径

    // 使用了 visited[][] 保存哪些点访问过 结果超时了

    int res = 0;

    public void dfs(int[][] matrix,boolean[][] visited,int x,int y,int lastNum,int cnt){
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(x<0 || y<0 || x>=rows || y>=cols || visited[x][y] || matrix[x][y]<=lastNum){
            res = Math.max(res,cnt);
            return;
        }
        visited[x][y] = true;
        int nowNum = matrix[x][y];
        dfs(matrix,visited,x+1,y,nowNum,cnt+1);
        dfs(matrix,visited,x-1,y,nowNum,cnt+1);
        dfs(matrix,visited,x,y+1,nowNum,cnt+1);
        dfs(matrix,visited,x,y-1,nowNum,cnt+1);
        visited[x][y] = false;
    }


    public int solve (int[][] matrix) {
        // write code here
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dfs(matrix,new boolean[matrix.length][matrix[0].length],i,j,-1,0);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {4,3,3,6,6,3,2,1,0,7},
                {1,8,2,8,5,9,2,8,3,1},
                {8,0,9,2,4,3,2,4,3,7},
                {1,2,2,6,3,0,3,9,7,0},
                {7,4,3,8,8,3,2,4,6,8},
                {2,8,9,2,9,3,0,8,7,8},
                {8,9,9,4,6,3,3,4,9,6},
                {2,8,3,8,1,3,7,3,0,7},
                {2,1,1,6,4,1,0,8,1,6},
                {4,1,3,6,3,4,4,4,0,3}
        };
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int res = new BM61().solve(matrix);
        System.out.println(res);

    }
}
