package cn.njust.leetcode.Huawei0920;

import java.util.Stack;

public class LK20 {

    // 20. 有效的括号

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        int len = chs.length;
        for(int i=0;i<len;i++){
            char ch = chs[i];
            if(stack.isEmpty() || ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
                continue;
            }
            if(ch==')' && stack.peek()=='(' || ch==']' && stack.peek()=='[' || ch=='}' && stack.peek()=='{'){
                stack.pop();
            }else{
                break;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }
}
