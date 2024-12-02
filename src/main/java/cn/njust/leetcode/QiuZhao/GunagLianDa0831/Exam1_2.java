package cn.njust.leetcode.QiuZhao.GunagLianDa0831;

import java.util.Scanner;

public class Exam1_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] launch = new int[n+1];
        int[] arrive = new int[n+1];

        for(int i=1;i<=n;i++){
            int tmp = sc.nextInt();
            launch[tmp] = i;
        }
        for(int i=1;i<=n;i++){
            int tmp = sc.nextInt();
            arrive[tmp] = i;
        }
        int res = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(launch[i]>launch[j] && arrive[i]<arrive[j]){
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);

    }
}
