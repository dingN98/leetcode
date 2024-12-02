package cn.njust.leetcode.Huawei0920;

import java.util.Stack;

public class LK394 {

    // 394. 字符串解码
    public String decodeString(String s) {

        // 栈
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for(int i=0;i<chs.length;i++){
            char ch = chs[i];
            if(stack.isEmpty() || ch!=']'){
                stack.push(ch);
                continue;
            }
            // 出栈计算
            StringBuilder sB = new StringBuilder();
            while(!stack.isEmpty() && stack.peek()!='['){
                sB.append(stack.pop());
            }
            String str = sB.reverse().toString();
            // [ 出栈
            stack.pop();
            // 操作数出栈
            StringBuilder num = new StringBuilder();
            while(!stack.isEmpty() && stack.peek()>='0' && stack.peek()<='9'){
                num.append(stack.pop());
            }
            int cnt = Integer.parseInt(num.reverse().toString());

            StringBuilder res = new StringBuilder();
            while(cnt>0){
                res.append(str);
                cnt--;
            }
            // 新的字符串进栈
            for(int j=0;j<res.length();j++){
                stack.push(res.charAt(j));
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();

    }

    public static void main(String[] args) {

    }
}
