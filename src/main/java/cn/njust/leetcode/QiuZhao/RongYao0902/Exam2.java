package cn.njust.leetcode.QiuZhao.RongYao0902;

public class Exam2 {

    public int lengthOfLongestSubstring (String src) {
        // write code here
        int[] last = new int[128];
        for(int i=0;i<128;i++){
            last[i] = -1;
        }
        int n = src.length();
        int res = 0;
        int start = 0;
        for(int i=0;i<n;i++){
            int index = src.charAt(i);
            start = Math.max(start,last[index]+1);
            res = Math.max(res,i-start+1);
            last[index] = i;
        }
        return res;

    }
}
