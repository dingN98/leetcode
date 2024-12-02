package cn.njust.leetcode.Huawei0920;

import java.util.ArrayDeque;

public class LK3 {

    public int lengthOfLongestSubstring(String s) {

        char[] chs = s.toCharArray();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        int maxLen = 0;
        for(int i=0;i<chs.length;i++){
            char ch = chs[i];
            if(queue.isEmpty() || !queue.contains(ch)){
                queue.addLast(ch);
                maxLen = Math.max(maxLen,queue.size());
                continue;
            }
            while (queue.contains(ch)){
                queue.pop();
            }
            queue.addLast(ch);
            maxLen = Math.max(maxLen,queue.size());
        }
        return maxLen;

    }

    public static void main(String[] args) {

        String s = "bbbb";
//        String s = "abcabcbb";
        int res = new LK3().lengthOfLongestSubstring(s);
        System.out.println(res);

    }
}
