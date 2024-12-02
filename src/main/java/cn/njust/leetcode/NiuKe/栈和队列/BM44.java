package cn.njust.leetcode.NiuKe.栈和队列;

import java.util.Stack;

public class BM44 {
    // 有效括号序列  简单题
    // 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
    // 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。

    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for(int i=0;i<chs.length;i++){
            char ch = chs[i];
            if(stack.isEmpty() || ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
            }else{
                char ch2 = stack.peek();
                if(ch2=='(' && ch==')' || ch2=='['&&ch==']' || ch2=='{'&&ch=='}'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "]]]]]]]";
//        String str = "([)]";
//        String str = "()[]{}";
        boolean res = new BM44().isValid(str);
        System.out.println(res);

    }


}
