package cn.njust.leetcode.NiuKe.双指针;

import java.util.HashSet;

public class BM90 {

    // BM90 最小覆盖子串  中等


    public String minWindow (String S, String T) {
        // write code here
        int left = 0,right = 0;
        int len = S.length();
        String res = "";
        int minLen = Integer.MAX_VALUE;
        HashSet<Character> set = new HashSet<>();
        while(right<len){
            char ch = S.charAt(right);

            if(T.contains(ch+"") && !set.contains(ch)){
                set.add(ch);
            }
            if(set.size()==T.length()){
                // 覆盖完成
                int tmpLen = right-left+1;
                if(tmpLen<minLen){
                    tmpLen = minLen;
                    res = S.substring(left,right+1);
                }
                //
            }
        }
        return "";
    }

    public static void main(String[] args) {

    }
}
