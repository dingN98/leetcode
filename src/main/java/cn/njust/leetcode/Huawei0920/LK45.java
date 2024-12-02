package cn.njust.leetcode.Huawei0920;

public class LK45 {

    // 45. 跳跃游戏 II

    public int jump(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];
        for(int i=1;i<len;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(j+nums[j]>=i){
                    // 能跳过来
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[len-1];

    }


}
