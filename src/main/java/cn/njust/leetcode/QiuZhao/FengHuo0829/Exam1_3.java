package cn.njust.leetcode.QiuZhao.FengHuo0829;

import java.util.Scanner;

public class Exam1_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        long t = a+b;
        long MIN = Long.MAX_VALUE;
        long MAX = 0;
        for(long i=0;i<=t;i+=c){
            long tmp = (i/c)+((t-i)/c);
            if(tmp>=MAX){
                MAX = tmp;
                MIN = Math.min(MIN,2*Math.abs(i-a));
            }
        }
        System.out.println(MIN);

    }
}
