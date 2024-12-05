package cn.cetc28.leetcode;

import sun.nio.cs.FastCharsetProvider;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/5 22:03
 * 022 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Test1205 {

    public static void main(String[] args) {
        Test1205 t = new Test1205();
        int n = 8;
        List<String> res = t.generateParenthesis(n);
        System.out.println(res);

    }

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        fun(2*n,0,"",res);
        return res;

    }

    public boolean isRight(String str){
        Stack<Character> stack = new Stack();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    Character ch = stack.peek();
                    if(ch!='('){
                        return false;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public void fun(int height,int index, String path,List<String> res){
        if(index>=height){
            if(isRight(path)){
                res.add(path);
            }
            return;
        }
        fun(height,index+1,path+"(",res);
        fun(height,index+1,path+")",res);
    }
}
