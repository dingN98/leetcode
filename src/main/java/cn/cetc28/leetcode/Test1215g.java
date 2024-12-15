package cn.cetc28.leetcode;

import jdk.nashorn.internal.ir.debug.NashornTextifier;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/15 19:08
 * 052 N皇后II
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 */
public class Test1215g {

    public int totalNQueens(int n) {
        List<Integer> res = new ArrayList<>();
        Character[][] board = new Character[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        boolean[] visited = new boolean[n];
        fun(board,visited,0,res);
        return res.size();

    }


    public void fun(Character[][] board, boolean[] visited, int line, List<Integer> res){
        int len = board.length;
        if(line==len){
            res.add(1);
            return;
        }
        for(int i=0;i<len;i++){
            if(!visited[i] && isValid(board,line,i)){
                visited[i] = true;
                board[line][i] = 'Q';
                fun(board,visited,line+1,res);
                board[line][i] = '.';
                visited[i] = false;
            }
        }
    }

    public boolean isValid(Character[][] board,int line,int col){
        int len = board.length;
        // 检查斜线位置是否存在皇后
        for(int j=1;j<len;j++){
            if((line+j)<len && (col+j)<len){
                if(board[line+j][col+j]=='Q'){
                    return false;
                }
            }
            if((line+j)<len && (col-j)>=0){
                if(board[line+j][col-j]=='Q'){
                    return false;
                }
            }
            if((line-j)>=0 && (col-j)>=0){
                if(board[line-j][col-j]=='Q'){
                    return false;
                }
            }
            if((line-j)>=0 && (col+j)<len){
                if(board[line-j][col+j]=='Q'){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test1215g t = new Test1215g();
        System.out.println(t.totalNQueens(8));

    }
}
