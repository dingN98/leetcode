package cn.njust.leetcode.QiuZhao.JingDong0903;

import java.util.Arrays;
import java.util.Scanner;

public class Exam2_2 {

    public static int fun(int x){
        int res = x;
        for(int i=2;i<=x/2;i++){
            int k = x/i;
            if(k*i==x){
                res = x/i;
            }
        }
        return res;

    }

    public static boolean isPrime(int x){
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int res = 0;
        int len = sc.nextInt();
        int[] A = new int[len];
        for(int i=0;i<len;i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int[] dp = new int[100001];
        for(int i=0;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 3;
        dp[6] = 4;
        for(int i=7;i<=A[len-1];i++){
            if(isPrime(i)){
                dp[i] = dp[i-1]+1;
            }else{
                for(int j=2;j<=i/2;j++){
                    int k = i/j;
                    if(k*j==i){
                        dp[i] = Math.min(dp[i],dp[k]+dp[j]+1);
                    }
                }
                dp[i] = Math.min(dp[i-1]+1,dp[i]);
            }

        }
        int res = 0;
        for(int i=0;i<len;i++){
            res += dp[A[i]];
        }
        System.out.println(res);

    }
}
