package cn.njust.leetcode.QiuZhao.XiaoHongShu0925;

import java.util.Arrays;
import java.util.Scanner;

public class Exam3_2 {

    int res = Integer.MAX_VALUE;

    int minDis = Integer.MAX_VALUE;

    public void getDis(int[][] matrix,int nodeNow,int nodeGoal,boolean[] visited,int path){
        int nodeNum = visited.length-1;
        if(nodeNow == nodeGoal){
            minDis = Math.min(minDis,path);
            return;
        }
        for(int i=1;i<=nodeNum;i++){
            if(visited[i] || matrix[nodeNow][i] == Integer.MAX_VALUE){
                continue;
            }
            visited[i] = true;
            getDis(matrix,i,nodeGoal,visited,path+matrix[nodeNow][i]);
            visited[i] = false;
        }
    }

    public int fun(int[][] matrix,int[] loc){

        int nodesNum = matrix.length-1;

        for(int nodeGoal = 1;nodeGoal<=nodesNum;nodeGoal++){
            int disSum = 0;
            for(int nodeNow:loc){
                minDis = Integer.MAX_VALUE;
                getDis(matrix,nodeNow,nodeGoal,new boolean[nodesNum+1],0);
                // 将任意两点之间的最短长度和缓存起来  不要重复计算
                matrix[nodeNow][nodeGoal] = minDis;
                if(minDis == Integer.MAX_VALUE){
                    disSum = -1;
                    break;
                }
                disSum += minDis;
            }
            if(disSum!=-1){
//                System.out.println("距离和 "+disSum);
                res = Math.min(res,disSum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodesNum = sc.nextInt();
        int[][] matrix = new int[nodesNum+1][nodesNum+1];
        for(int i=0;i<matrix.length;i++){
            Arrays.fill(matrix[i],Integer.MAX_VALUE);
        }
        for(int i=1;i<=nodesNum;i++){
            matrix[i][i] = 0;
        }
        int[] a1 = new int[nodesNum-1];
        int[] a2 = new int[nodesNum-1];
        for(int i=0;i<nodesNum-1;i++){
            a1[i] = sc.nextInt();
        }
        for(int i=0;i<nodesNum-1;i++){
            a2[i] = sc.nextInt();
        }
        for(int i=0;i<nodesNum-1;i++){
            int node1 = i+2;
            int node2 = a1[i];
            int dis = a2[i];
            matrix[node1][node2] = dis;
            matrix[node2][node1] = dis;
        }
        int[] loc = new int[3];
        for(int i=0;i<3;i++){
            loc[i] = sc.nextInt();
        }

        int res = new Exam3_2().fun(matrix,loc);
        System.out.println(res);


//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[i].length;j++){
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }

    }
}
