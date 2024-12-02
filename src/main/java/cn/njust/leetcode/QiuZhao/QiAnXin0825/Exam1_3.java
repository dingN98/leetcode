package cn.njust.leetcode.QiuZhao.QiAnXin0825;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Exam1_3 {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public void dfs(int[][] graph,int x,int n){
        if(x==n){
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for(int y:graph[x]){
            stack.offerLast(y);
            dfs(graph,y,n);
            stack.pollLast();
        }
    }


    public int DagvisitedNum (int[][] nodes) {
        stack.offerLast(0);
        dfs(nodes,0, nodes.length-1);
        return ans.size();
    }

    public static void main(String[] args) {

        int[][] nodes = new int[5][5];
        nodes[0] = new int[]{1,2,3};
        nodes[1] = new int[]{3};
        nodes[2] = new int[]{3};
        nodes[3] = new int[]{4};
        nodes[4] = new int[]{};
        int res = new Exam1_3().DagvisitedNum(nodes);
        System.out.println(res);
    }
}
