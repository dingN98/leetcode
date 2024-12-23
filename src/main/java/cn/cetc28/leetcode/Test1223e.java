package cn.cetc28.leetcode;

import javax.swing.text.StyledEditorKit;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/23 21:11
 * 079 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Test1223e {

    public boolean search(char[][] board, int x, int y, int idx,boolean[][] visited,String target){
        if(idx==target.length()){
            return true;
        }
        int lines = board.length;
        int cols = board[0].length;
        if(x<0 || x>=lines || y<0 ||y>=cols ||visited[x][y] || board[x][y]!=target.charAt(idx)){
            return false;
        }
        visited[x][y] = true;
        idx++;
        boolean b1 = search(board,x+1,y,idx,visited,target);
        boolean b2 = search(board,x-1,y,idx,visited,target);
        boolean b3 = search(board,x,y+1,idx,visited,target);
        boolean b4 = search(board,x,y-1,idx,visited,target);
        visited[x][y] = false;
        return b1||b2||b3||b4;
    }

    public boolean exist(char[][] board, String word) {
        int lines = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[lines][cols];
        for(int i=0;i<lines;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean tmp = search(board, i, j, 0, visited, word);
                    if(tmp){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Test1223e t = new Test1223e();
        System.out.println(t.exist(board, word));

    }
}
