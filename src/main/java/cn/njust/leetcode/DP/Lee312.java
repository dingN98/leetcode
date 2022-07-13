package cn.njust.leetcode.DP;

public class Lee312 {

    public int maxCoins(int[] nums) {
        int len = nums.length;

        int[][] dp = new int[len][len];

        // dp[i][j]  表示 第 i 轮  戳破 第 j 个气球获得的收益
        // 状态：  就是第i轮戳破第j个球


        // 初始化
        for(int i=0;i<len;i++){
            int y1 = (i-1)>=0?nums[i-1]:1;
            int y2 = (i+1)<len?nums[i+1]:1;
            dp[0][i] =  y1*nums[i]*y2;
        }
        //
        for(int i=1;i<len;i++) {
            int tmp = 0;
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (k != j) {
                        tmp = Math.max(tmp, dp[i - 1][k]);
                    }
                }
            }
        }
        return 0;

    }

}
