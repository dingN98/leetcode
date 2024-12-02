package cn.njust.leetcode.JZOffer;

import java.util.Locale;

public class JZ12 {

    // 请设计一个函数，用来判断在一个n乘m的矩阵中是否存在一条包含某长度为len的字符串所有字符的路径。
    // 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
    // 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
    public boolean hasPath (char[][] matrix, String word) {
        // write code here
        char[] word2 = word.toCharArray();
        boolean res = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                res = res || fun(matrix,i,j,visited,word2,0);
            }
        }
        return res;
    }

    public boolean fun(char[][] matrix,int x,int y,boolean[][] visited,char[] word,int idx){
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(x<0 || y<0 || x>=rows || y>=cols || visited[x][y]){
            return false;
        }

        if(idx==word.length-1 && word[idx]==matrix[x][y]){
            return true;
        }
        if(matrix[x][y] != word[idx]){
            return false;
        }
//        System.out.println("x: "+x+" y: "+y+" v: "+matrix[x][y]);

        visited[x][y] = true;
        boolean res = fun(matrix,x+1,y,visited,word,idx+1) || fun(matrix,x-1,y,visited,word,idx+1) ||
                fun(matrix,x,y+1,visited,word,idx+1) ||fun(matrix,x,y-1,visited,word,idx+1);
        visited[x][y] = false;

        return res;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        String word = "abcced";
        boolean res = new JZ12().hasPath(matrix,word);
        System.out.println(res);

    }

}
