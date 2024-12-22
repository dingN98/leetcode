package cn.cetc28.leetcode;

import java.util.Stack;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/22 18:43
 * 071 简化路径
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中规则如下：
 *
 * 一个点 '.' 表示当前目录本身。
 * 此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
 * 任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
 * 任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
 * 返回的 简化路径 必须遵循下述格式：
 *
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 */
public class Test1222 {

    public String simplifyPath(String path) {
        int dotCnt = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<path.length();i++){
            System.out.println("i="+i+",stack="+stack.toString());
            char ch = path.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
            }else {
                if (stack.peek() == '/') {
                    if (ch == '/') {
                        // 重复的/算一个
                    } else if (ch == '.') {
                        dotCnt++;
                        stack.push(ch);
                        // 如果是最后一个. 还需要判断
                        if(i==path.length()-1){
                            if (dotCnt == 2) {
                                // 回退  /home/user/Documents/../Pictures  ——>  /home/user/Pictures
                                stack.pop();
                                stack.pop();
                                if(stack.size()>1){
                                    stack.pop();
                                    while (!stack.isEmpty() && stack.peek() != '/') {
                                        stack.pop();
                                    }
                                }
                            }else if(dotCnt==1){
                                stack.pop();
                            }
                        }
                    }else{
                        stack.push(ch);
                    }
                } else if (stack.peek() == '.') {
                    if (ch == '.') {
                        if(dotCnt!=0){
                            dotCnt++;
                            stack.push(ch);
                            // 如果是最后一个. 还需要判断
                            if(i==path.length()-1){
                                if (dotCnt == 2) {
                                    // 回退  /home/user/Documents/../Pictures  ——>  /home/user/Pictures
                                    stack.pop();
                                    stack.pop();
                                    if(stack.size()>1){
                                        stack.pop();
                                        while (!stack.isEmpty() && stack.peek() != '/') {
                                            stack.pop();
                                        }
                                    }
                                }else if(dotCnt==1){
                                    stack.pop();
                                }
                            }
                        }else{
                            stack.push(ch);
                        }
                    } else if (ch == '/') {
                        if (dotCnt == 2) {
                            // 回退  /home/user/Documents/../Pictures  ——>  /home/user/Pictures
                            stack.pop();
                            stack.pop();
                            if(stack.size()>1){
                                stack.pop();
                                while (!stack.isEmpty() && stack.peek() != '/') {
                                    stack.pop();
                                }
                            }
                        }else if(dotCnt==1){
                            stack.pop();
                        }else{
                            stack.push(ch);
                        }
                        dotCnt = 0;
                    }else{
                        stack.push(ch);
                    }
                }else{
                    dotCnt=0;
                    stack.push(ch);
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
        if(res.length()==0){
            res.append('/');
        }
        return res.reverse().toString();

    }

    public static void main(String[] args) {

        Test1222 t = new Test1222();
        System.out.println(t.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/"));

    }
}
