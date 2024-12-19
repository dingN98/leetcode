package cn.cetc28.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/18 19:35
 * 060 排列序列
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 */
public class Test1218b {

    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n+1];
        List<String> res = new ArrayList<>();
        fun(n,0,k,visited,"",res);
        if(res.size()>0){
            return res.get(k-1);
        }
        return "";
    }

    public void fun(int n, int idx, int k, boolean[] visited, String path, List<String> res){
        if(res.size()==k){
            return;
        }
        if(idx==n){
            res.add(path);
            return;
        }
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                fun(n,idx+1,k,visited,path+i,res);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Test1218b t = new Test1218b();
        System.out.println(t.getPermutation(3, 1));

    }
}
