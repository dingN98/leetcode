package cn.njust.leetcode.QiuZhao.FengHuo0829;

import java.util.Scanner;

public class Exam2 {

    // 计算前缀和
    public static int[][] getSum(int[][] a){
        int n = a.length;
        int m = a[0].length;
        int[][] s = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    s[i][j] = a[i][j];
                    continue;
                }
                if(i==0){
                    s[i][j] = s[i][j-1]+a[i][j];
                    continue;
                }
                if(j==0){
                    s[i][j] = s[i-1][j]+a[i][j];
                    continue;
                }
                s[i][j] = s[i-1][j]+s[i][j-1]-s[i-1][j-1]+a[i][j];
            }
        }
        return s;
    }
    // 计算小矩阵
    public static int getSum2(int[][] s,int x1, int y1,int d){
        int x2 = x1 + d - 1;
        int y2 = y1 + d - 1;
        int res = 0;
        if(x1==0 && y1==0){
            res = s[x2][y2];
            return res;
        }
        if(x1==0){
            res = s[x2][y2]  - s[x2][y1-1];
            return res;
        }
        if(y1==0){
            res = s[x2][y2] - s[x1-1][y2];
            return res;
        }
        res = s[x2][y2] - s[x1-1][y2] - s[x2][y1-1] + s[x1-1][y1-1];
//        System.out.println(x1+","+y1+" 的矩阵和为"+res);
        return res;
    }

    // 计算公约数
    public static int getYinShu(int a,int b){
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if(big%small==0){
            return small;
        }
        return getYinShu(big%small,small);
    }

    public static void printMatrix(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int[][] a = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j] = getYinShu(i+1,j+1);
            }
        }

//        printMatrix(a);

        int[][] s = getSum(a);

//        printMatrix(s);

        int res = 0;
        for(int i=0;i<(n-d+1);i++){
            for(int j=0;j<(m-d+1);j++){
                res += getSum2(s,i,j,d);
            }
        }
        System.out.println(res);
    }
}
