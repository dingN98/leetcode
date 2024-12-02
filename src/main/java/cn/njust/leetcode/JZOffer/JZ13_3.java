package cn.njust.leetcode.JZOffer;

import java.util.HashSet;

public class JZ13_3 {

    // 机器人的运动范围
    // 地上有一个 rows 行和 cols 列的方格。坐标从 [0,0] 到 [rows-1,cols-1] 。
    // 一个机器人从坐标 [0,0] 的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 threshold 的格子。
    // 例如，当 threshold 为 18 时，机器人能够进入方格   [35,37] ，因为 3+5+3+7 = 18。
    // 但是，它不能进入方格 [35,38] ，因为 3+5+3+8 = 19 。
    // 请问该机器人能够达到多少个格子？
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return fun(threshold,0,0,visited);
    }

    public int fun(int threshold, int x, int y,boolean[][] visited){
        int rows = visited.length;
        int cols = visited[0].length;
        if(x<0 || y<0 || x>=rows || y>=cols || visited[x][y] || !canArrive(threshold,x,y)){
            return 0;
        }
        visited[x][y] = true;
        return 1+fun(threshold,x+1,y,visited)+fun(threshold,x-1,y,visited)+fun(threshold,x,y+1,visited)+fun(threshold,x,y-1,visited);
    }

    public boolean canArrive(int threshold,int x,int y){
        String key = x+""+y;
        int res = 0;
        for(int i=0;i<key.length();i++){
            res += Integer.parseInt(key.charAt(i)+"");
        }
        return res<=threshold;
    }

    public static void main(String[] args) {

//        int res = new JZ13_2().movingCount(1,2,3);
        int res = new JZ13_3().movingCount(15,20,20);
        System.out.println(res);

    }
}
