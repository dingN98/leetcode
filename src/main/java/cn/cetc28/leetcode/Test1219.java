package cn.cetc28.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/19 19:51
 * 062 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 */
public class Test1219 {
    public int uniquePaths(int m, int n) {
        return fun(m,n,1,1);

    }

    public int fun(int m, int n, int x, int y){
        if(x==m && y==n){
            return 1;
        }
        if(x>m || y>n){
            return 0;
        }
        return fun(m,n,x+1,y)+fun(m,n,x,y+1);
    }

    public static void main(String[] args) {

        Test1219 t = new Test1219();
        System.out.println(t.uniquePaths(100, 100));

    }
}
