package cn.njust.leetcode.JZOffer;

public class JZ70 {

    // 矩形覆盖
    // 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，从同一个方向看总共有多少种不同的方法？
    public int rectCover(int target) {
        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=target;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[target];

    }

}
