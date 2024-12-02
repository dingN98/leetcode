package cn.njust.leetcode.QiuZhao.XiaoHongShu0904;

import java.util.Scanner;

public class Exam3 {

    static int res = Integer.MAX_VALUE;

    public static void dfs(int[][] matrix,int j,int[] visited,int goat,int n,int k,int path){
        if(j<0 || j>=matrix[0].length || visited[j]==1){
            return;
        }
        if(path+1>k){
            return;
        }
        visited[j] = 1;
        int t = matrix[1][j];
        if(t==n){
            goat = Math.max(goat,matrix[2][j]);
            res = Math.min(res,goat);
            return;
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==t){
                dfs(matrix,i,visited,Math.max(goat,matrix[2][i]),n,k,path+1);
            }
        }
        visited[j] = 0;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] matrix = new int[3][m];
        for(int i=0;i<3;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int[] visited = new int[m];
        for(int j=0;j<m;j++){
            if(matrix[0][j]==1){
                dfs(matrix,j,visited,matrix[2][j],n,k,0);
            }
        }
        System.out.println(res);
;

    }
}
