package cn.cetc28.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/23 20:46
 * 077 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
public class Test1223c {

    public void fun(int n,int k,int cnt,int now,List<List<Integer>> res,List<Integer> path){
        if(cnt==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=now+1;i<=n;i++){
            path.add(i);
            fun(n,k,cnt+1,i,res,path);
            path.remove(path.size()-1);
        }

    }

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res  = new ArrayList<>();
        fun(n,k,0,0,res,new ArrayList<>());
        return res;

    }

    public static void main(String[] args) {

        Test1223c t = new Test1223c();
        System.out.println(t.combine(6, 4));

    }
}
