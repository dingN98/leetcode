package cn.njust.leetcode.QiuZhao.HuaWei0831;

import java.util.Scanner;

public class Exam2 {

    static int minTime = Integer.MAX_VALUE;

    public static void search(int[][] board,int x,int y,boolean[][] visited,int cost){
//        System.out.println("位置  "+x+" , "+y);
        int rows = board.length;
        int cols = board[0].length;
        if(x<0 || x>=rows || y<0 || y>=cols || visited[x][y]){
            return;
        }
        int kind = board[x][y];
        if(kind==1){
            return;
        }
        if(kind==3){
            minTime = Math.min(minTime,cost);
            return;
        }
        visited[x][y] = true;
        int t = 0;
        if(kind==0 || kind==2){
            t = 1;
            search(board,x+1,y,visited,cost+t);
            search(board,x-1,y,visited,cost+t);
            search(board,x,y+1,visited,cost+t);
            search(board,x,y-1,visited,cost+t);
        }else if(kind==4){
            t = 3;
            board[x][y] = 0;
            search(board,x+1,y,visited,cost+t);
            search(board,x-1,y,visited,cost+t);
            search(board,x,y+1,visited,cost+t);
            search(board,x,y-1,visited,cost+t);
            board[x][y] = 4;
        }else{;
            t = 1;
            board[x][y] = 0;
            int flag1=0,flag2=0,flag3=0,flag4=0;
            if(x-1>=0 && board[x-1][y]==1){
                flag1=1;
                board[x-1][y]=0;
            }
            if(x+1<rows && board[x+1][y]==1){
                flag2=1;
                board[x+1][y]=0;
            }
            if(y-1>=0 && board[x][y-1]==1){
                flag3=1;
                board[x][y-1]=0;
            }
            if(y+1<cols && board[x][y+1]==1){
                flag4=1;
                board[x][y+1]=0;
            }
            search(board,x+1,y,visited,cost+t);
            search(board,x-1,y,visited,cost+t);
            search(board,x,y+1,visited,cost+t);
            search(board,x,y-1,visited,cost+t);

            if(flag1==1){
                board[x-1][y]=1;
            }
            if(flag2==1){
                board[x+1][y]=1;
            }
            if(flag3==1){
                board[x][y-1]=1;
            }
            if(flag4==1){
                board[x][y+1]=1;
            }
            board[x][y] = 6;
        }
        visited[x][y] = false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int sX = 0,sY = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] = sc.nextInt();
                if(board[i][j]==2){
                    sX = i;
                    sY = j;
                }
            }
        }
        search(board,sX,sY,visited,0);
        System.out.println(minTime);

    }
}
