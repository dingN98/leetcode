package cn.cetc28.leetcode;

import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;

import java.security.BasicPermission;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/15 18:28
 * 051 N皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 */
public class Test1215f {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Character[][] board = new Character[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        boolean[] visited = new boolean[n];
        fun(board,visited,0,res);
        return res;
    }

    public void fun(Character[][] board,boolean[] visited,int line,List<List<String>> res){
        int len = board.length;
        if(line==len){
            List<String> path = new ArrayList<>();
            for(int i=0;i<len;i++){
                StringBuilder tmp = new StringBuilder();
                for(int j=0;j<len;j++){
                    tmp.append(board[i][j]);
                }
                path.add(tmp.toString());
            }
            res.add(path);
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

        Test1215f t = new Test1215f();
        System.out.println(t.solveNQueens(4));

    }




}
