package cn.njust.leetcode.Huawei0920;

public class LK97 {

    // 交错字符串
    // 直接看题解
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1+len2!=len3 || s1.length()==0 && !s2.equals(s3) || s2.length()==0 && !s1.equals(s3)){
            return false;
        }
        // dp[i][j] 表示使用s1的第i个字符 使用s2的第j的字符  i和j从1开始，0代表不使用
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i=1;i<=len1;i++){
            dp[i][0] = dp[i-1][0] && (s1.charAt(i-1)==s3.charAt(i-1));
        }
        for(int j=1;j<=len2;j++){
            dp[0][j] = dp[0][j-1] && (s2.charAt(j-1)==s3.charAt(j-1));
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                dp[i][j] = dp[i-1][j] && (s1.charAt(i-1)==s3.charAt(i+j-1)) || dp[i][j-1] && (s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        return dp[len1][len2];


    }
}