package cn.cetc28.leetcode;

import javax.lang.model.type.ErrorType;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/2 21:16
 * 005 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串
 * 。
 */
public class Test1202 {

    public static void main(String[] args) {
//        String s = "abcdcbakkkkk";
        String s = "cbbd";
        Test1202 t = new Test1202();
        System.out.println(t.longestPalindrome(s));


    }

    // 看题解后
//    public String fun(String s){
//        char[] s1 = s.toCharArray();
//        int len = s.length();
//        boolean[][] table = new boolean[len][len];
//        for(int i=0;i<len;i++){
//            for(int j=0;j<len;j++){
//                if(i==j){
//                    table[i][i] = true;
//                    break;
//                }
//                if(table[i][j]){
//                    if(s1[i]==s1[j]){
//
//                    }
//                }
//
//            }
//
//        }
//    }

    // 看题解前
    public String longestPalindrome(String s) {
        // 时间复杂福 O(N2)
        // 空间复杂度 O(1)
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int l1 = s.length(),r1 = 0;
        for (int i=0;i<s.length();i++){
            left = i;
            right = i;
            while((right+1)<s.length() && s.charAt(right)==s.charAt(right+1)){
                right++;
            }
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if(maxLen<(right-left+1)){
                    maxLen = right-left+1;
                    l1 = left;
                    r1 = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(l1,r1+1);

    }
}
