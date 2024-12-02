package cn.njust.leetcode.Huawei0920;

import java.util.Stack;

public class LK227 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chs = s.toCharArray();
        int d = 0;
        char sign = '+';

        for(int i=0;i<chs.length;i++){
            char ch = chs[i];
            if(ch>='0'){
                // 操作数
                d = d*10+(ch-'0');
            }
            if(ch<'0' && ch!=' ' || i==chs.length-1){
                if(sign=='+'){
                    stack.push(d);
                }else if(sign=='-'){
                    stack.push(-d);
                }else{
                    // 乘除
                    if(sign=='*'){
                        stack.push(stack.pop()*d);
                    }else{
                        stack.push(stack.pop()/d);
                    }
                }
                d = 0;
                sign = ch;
            }
        }

        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
