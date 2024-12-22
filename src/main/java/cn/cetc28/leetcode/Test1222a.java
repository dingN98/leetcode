package cn.cetc28.leetcode;

import jdk.nashorn.internal.runtime.regexp.joni.constants.internal.StackPopLevel;

import java.util.Stack;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/22 19:24
 * 071 简化路径
 */
public class Test1222a {


    public String simplifyPath(String path){

        int dotCnt = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<path.length();i++){
            System.out.println("i="+i+",stack="+stack.toString());
            char ch = path.charAt(i);
            if(ch!='/' && ch!= '.'){
                dotCnt = 0;
                stack.push(ch);
            }else if(ch=='.'){
                if(!stack.isEmpty()){
                    if(stack.peek()=='/'){
                        dotCnt=1;
                    }else if(stack.peek()=='.'){
                        if(dotCnt>0){
                            dotCnt++;
                        }
                    }
                }
                stack.push(ch);
                // 如果是最后一个.
                if(i==path.length()-1){
                    //   /./ 或者  /../  或者 /.../
                    if(dotCnt==1){
                        // 去除.
                        stack.pop();
                    }else if(dotCnt==2){
                        // 去除..
                        stack.pop();
                        stack.pop();
                        if(stack.size()>1){
                            stack.pop();
                            while(!stack.isEmpty() && stack.peek()!='/'){
                                stack.pop();
                            }
                        }
                    }
                }
            }else {
                // ch=='/'
                if(stack.isEmpty()){
                    stack.push(ch);
                }else{
                    if(stack.peek()=='/'){
                        // 不要放置重复的/
                    }else if(dotCnt>0){
                        //   /./ 或者  /../  或者 /.../
                        if(dotCnt==1){
                            // 去除.
                            stack.pop();
                        }else if(dotCnt==2){
                            // 去除..
                            stack.pop();
                            stack.pop();
                            if(stack.size()>1){
                                stack.pop();
                                while(!stack.isEmpty() && stack.peek()!='/'){
                                    stack.pop();
                                }
                            }
                        }else{
                            // 题目认为超过2个的.是正经目录，不要动
                            stack.push(ch);
                        }
                    }else{
                        stack.push(ch);
                    }
                }
            }
        }
        if(stack.size()>1 && stack.peek()=='/'){
            stack.pop();
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();

    }
    public static void main(String[] args) {
        Test1222a t = new Test1222a();
        System.out.println(t.simplifyPath("/a//b////c/d//././/.."));

    }
}
