package cn.njust.leetcode.Huawei0920;

public class LK55 {

    // 55 跳跃游戏
    public boolean canJump(int[] nums) {

        int len = nums.length;

        boolean[] dp = new boolean[len];

        dp[0] = true;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && nums[j]>=(i-j)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len-1];
    }

    public static void main(String[] args) {

    }
}
