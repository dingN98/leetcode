package cn.njust.leetcode.NiuKe.字符串;

import java.util.HashMap;
import java.util.HashSet;

public class BM84 {

    // BM84 最长公共前缀
    public String longestCommonPrefix (String[] strs) {
        // write code here
        int len = strs.length;
        StringBuilder res = new StringBuilder();
        int idx = 0;
        while(true){
            HashSet<Character> set = new HashSet<>();
            char chTmp = ' ';
            for (String str : strs) {
                if (idx >= str.length()) {
                    return res.toString();
                }
                char ch = str.charAt(idx);
                set.add(ch);
                chTmp = ch;
            }
            if(set.size()==1){
                res.append(chTmp);
                idx++;
                continue;
            }
            if(set.size()>1){
                return res.toString();
            }
            return "";
        }
    }

    public static void main(String[] args) {

        String[] strs = new String[3];
        strs[0] = "abcdef";
        strs[1] = "abcd";
        strs[2] = "ab";

        String res = new BM84().longestCommonPrefix(strs);
        System.out.println(res);

    }
}
