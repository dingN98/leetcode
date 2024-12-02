package cn.cetc28.leetcode;

import java.util.HashSet;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/1 23:13
 * 003 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 *  的长度。
 */
public class Test1201b {

    public static void main(String[] args) {

        Test1201b t = new Test1201b();
//        String s = "dvdf";
        String s = "abcabcbb";
//        String s = "abcbcdddddd";
        int res = t.lengthOfLongestSubstring(s);
        System.out.println(res);

    }

    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        char[] list = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        for(;right<len;right++){
            while (set.contains(list[right])){
                set.remove(list[left]);
                left++;
            }
            set.add(list[right]);

            System.out.println(s.substring(left,right+1));
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;




        /**
         * 第一版 时间复杂度被判定为 O(N2)  空间复杂度被判定为  O(N)
         * 看了官方教程 需要优化  成  空间 O(N) 时间 O(N)
         */
//        int len = s.length();
//        if(len <= 1){
//            return len;
//        }
//        int i=0;
//        int j=1;
//        int maxLen = 1;
//        for(;j<len;){
//            if(s.substring(i,j).contains(s.charAt(j)+"")){
//                i++;
//            }else{
//                maxLen = Math.max(maxLen,j-i+1);
//                j++;
//            }
//        }
//        return maxLen;
    }
}
