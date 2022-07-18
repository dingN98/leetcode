package cn.njust.leetcode.JZOffer;

public class JZ10 {

    public int Fibonacci(int n) {
        int[] dp = new int[n+1];
        if(n==1 || n==2){
            return 1;
        }
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = new JZ10().Fibonacci(4);
        System.out.println(res);
    }
}
