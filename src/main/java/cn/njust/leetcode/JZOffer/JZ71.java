package cn.njust.leetcode.JZOffer;

public class JZ71 {

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
    public int jumpFloorII(int target) {
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=target;i++){
            dp[i] = 1;
            for(int j=1;j<i;j++){
                dp[i] += dp[j];
            }
        }
        return dp[target];

    }
}
