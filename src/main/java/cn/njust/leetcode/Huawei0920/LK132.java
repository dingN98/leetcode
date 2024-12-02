package cn.njust.leetcode.Huawei0920;

public class LK132 {

    // 132. 分割回文串 II
    public int minCut(String s) {

        char[] chs =s.toCharArray();
        int len = chs.length;
        // dp[i] 表示  [0,i]之间的字串需要分割几次
        int[] dp = new int[len];
        for(int i=0;i<len;i++){
            if(isValid(s.substring(0,i+1))){
                dp[i] = 0;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                String str = s.substring(j+1,i+1);
                if(isValid(str)){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }

            }
        }
        return dp[len-1];
    }

    public boolean isValid(String str){
        char[] chs = str.toCharArray();
        int left = 0;
        int right = str.length()-1;
        while(left<right){
            if(chs[left]==chs[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
