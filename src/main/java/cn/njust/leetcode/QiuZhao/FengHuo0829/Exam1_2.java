package cn.njust.leetcode.QiuZhao.FengHuo0829;

import java.util.Scanner;

public class Exam1_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        long t = a+b;
        long MIN = Long.MAX_VALUE;
        long MAX = 0;
        for(long i=0;i<=t;i+=c){
            if((long)(i/c)+(long)((t-i)/c)>=MAX){
                MAX = (long)(i/c)+(long)((t-i)/c);
                MIN = Math.min(MIN,2*Math.abs(i-a));
            }
        }
        System.out.println(MIN);

    }
}
