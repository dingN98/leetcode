package cn.njust.leetcode.QiuZhao.meituan0806;

import java.util.Scanner;

public class Exam1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int turns = scanner.nextInt();
        int[] res = new int[turns];
        for(int t=0;t<turns;t++){
            int xNum = scanner.nextInt();
            int yNum = scanner.nextInt();
            int resTmp = 0;
            int n = (xNum+yNum)/3;
            if(Math.min(xNum,yNum)<=n){
                resTmp = Math.min(xNum,yNum);
            }else{
                resTmp = n;
            }
            res[t] = resTmp;
        }

        for(int t=0;t<turns;t++){
            System.out.println(res[t]);
        }

    }
}
