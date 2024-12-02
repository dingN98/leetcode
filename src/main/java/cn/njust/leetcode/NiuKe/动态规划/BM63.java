package cn.njust.leetcode.NiuKe.动态规划;

public class BM63 {

    public int jumpFloor(int target) {

        if(target==1 || target==2){
            return target;
        }
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=target;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[target];

    }


}
