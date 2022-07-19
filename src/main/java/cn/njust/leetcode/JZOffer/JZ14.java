package cn.njust.leetcode.JZOffer;

public class JZ14 {
    public int cutRope (int n) {

        // 长度为 i 的绳子 的乘积最大值

        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int[] dp = new int[n+1];
        // 这里默认  长为2或者3时   剪成一段
        dp[2] = 2;
        dp[3] = 3;

        for(int i=4;i<=n;i++){
            for(int j=2;j<i;j++){
                dp[i] = Math.max(dp[i],dp[i-j]*dp[j]);
//                System.out.println("dp["+i+"]= "+dp[i]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 8;
        int res = new JZ14().cutRope(n);
        System.out.println(res);
    }
}
