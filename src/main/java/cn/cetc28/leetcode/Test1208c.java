package cn.cetc28.leetcode;

import java.sql.Statement;
import java.util.Stack;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/8 15:54
 * 032 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class Test1208c {

    public static void main(String[] args) {

        String s = "()(())";
        Test1208c t = new Test1208c();
        int res = t.longestValidParentheses(s);
        System.out.println(res);

    }

    public int longestValidParentheses(String s) {

        int res = 0;
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            String ch = s.charAt(i)+"";
            if(")".equals(ch)){
                if(stack.isEmpty()){
                    stack.push(ch);
                }else{
                    String top = stack.peek();
                    if(")".equals(top)){
                        stack.push(ch);
                    }else if("(".equals(top)){
                        stack.pop();
                        int sum = 2;
                        while(!stack.isEmpty() && !"(".equals(stack.peek()) && !")".equals(stack.peek())){
                            sum += Integer.parseInt(stack.pop());
                        }
                        res = Math.max(res,sum);
                        stack.push(sum+"");
                    }else{
                        // top是数字
                        int sum = 0;
                        while(!stack.isEmpty() && !"(".equals(stack.peek()) && !")".equals(stack.peek())){
                            sum += Integer.parseInt(stack.pop());
                        }
                        if(stack.isEmpty()){
                            stack.push(sum+"");
                            res = Math.max(res,sum);
                            stack.push(ch);
                        }else{
                            String tmp2 = stack.peek();
                            if("(".equals(tmp2)){
                                stack.pop();
                                sum+=2;
                                while(!stack.isEmpty() && !"(".equals(stack.peek()) && !")".equals(stack.peek())){
                                    sum += Integer.parseInt(stack.pop());
                                }
                                res = Math.max(res,sum);
                                stack.push(sum+"");
                            }else{
                                stack.push(sum+"");
                                res = Math.max(res,sum);
                                stack.push(ch);
                            }
                        }
                    }
                }
            }else{
                stack.push(ch);
            }
            System.out.printf("%-15s->%-15s%n",s.substring(0,i+1),stack);
        }
        return res;


    }
}
