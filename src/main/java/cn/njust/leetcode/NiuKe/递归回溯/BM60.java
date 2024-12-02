package cn.njust.leetcode.NiuKe.递归回溯;

import cn.njust.leetcode.NiuKe.栈和队列.BM46;

import java.util.ArrayList;

public class BM60 {

    // 括号生成
    // 其实就是 在递归结束之前 右括号的数目得小于或者等于左括号的数目

    ArrayList<String> res = new ArrayList<>();

    public void dfs(int leftNum,int rightNum,int maxNum,String path){
        if(leftNum==maxNum && rightNum==maxNum){
            res.add(path);
            return;
        }
        if(rightNum>leftNum || leftNum>maxNum || rightNum>maxNum){
            return;
        }
        dfs(leftNum+1,rightNum,maxNum,path+"(");
        dfs(leftNum,rightNum+1,maxNum,path+")");
    }

    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        dfs(0,0,n,"");
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> res = new BM60().generateParenthesis(3);
        System.out.println(res);
    }

}
