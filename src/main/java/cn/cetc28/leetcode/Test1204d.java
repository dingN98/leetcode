package cn.cetc28.leetcode;

import java.util.Stack;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/4 22:51
 * 020 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class Test1204d {

    public static void main(String[] args) {
        Test1204d t = new Test1204d();
        String s = "()[]{}";
        System.out.println(t.isValid(s));
    }

    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<len;i++){
            Character ch = s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
            }
            if(ch==')'||ch=='}'||ch==']'){
                if(stack.isEmpty()){
                    return false;
                }
                Character ch2 = stack.peek();
                if(ch2=='(' && ch==')'||ch2=='{' && ch=='}'||ch2=='[' && ch==']'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
