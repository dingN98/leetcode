package cn.njust.leetcode.QiuZhao.meituan0806;

import java.util.Scanner;

public class Exam1_2 {
    public static int cal(int a,int b){
        int c = Math.min(a,b);
        int sum = a+b;
        int res = 0;
        if(sum<3){
            return res;
        }
        int i=Math.abs(a-b);
        for(;i<=c;i++){
            if(sum-2*i==i){
                break;
            }
        }
        i = Math.min(i,c);
        return i;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int turns = scanner.nextInt();
        int[] res = new int[turns];
        for(int t=0;t<turns;t++){
            int xNum = scanner.nextInt();
            int yNum = scanner.nextInt();
            res[t] = cal(xNum,yNum);
        }

        for(int t=0;t<turns;t++){
            System.out.println(res[t]);
        }

    }
}
