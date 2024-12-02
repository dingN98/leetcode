package cn.njust.leetcode.Huawei0920;

import java.util.Stack;

public class LK316 {

    // 316. 去除重复字母
    public String removeDuplicateLetters(String s) {
        // 直接看题解 单调栈
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        int len = chs.length;
        for(int i=0;i<chs.length;i++){
            char ch = chs[i];

            while(!stack.isEmpty() && !stack.contains(ch) && ch<stack.peek() && s.substring(i+1,len).contains(stack.peek()+"")){
                stack.pop();
            }
            if(!stack.contains(ch)){
                stack.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {

//        String s = "bcabc";
        String s = "abacb";
//        String s = "cbacdcbc";
        String res = new LK316().removeDuplicateLetters(s);
        System.out.println(res);

    }
}
