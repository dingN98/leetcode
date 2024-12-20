package cn.njust.leetcode.Huawei0920;

public class JZ10 {

    // 剑指 Offer 10- II. 青蛙跳台阶问题
    public int numWays(int n) {
        if(n<=1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%(1000000007);
        }
        return dp[n];

    }


}
