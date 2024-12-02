package cn.njust.leetcode.NiuKe.哈希;

import java.util.*;

public class BM54_2 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    // 三数之和
    // 方法2  dfs  会超时
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        dfs(nums,new boolean[nums.length],0,0,0,0);
        return res;
    }

    public void dfs(int[] nums,boolean[] visited,int idx,int cnt,int sum,int target){
        if(cnt==3){
            System.out.println("idx: "+idx+" cnt: "+cnt+" sum: "+sum);
        }

        int len = nums.length;
        if(cnt==3 && sum==target){
            //todo
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=0;i<len;i++){
                if(visited[i]){
                    tmp.add(nums[i]);
                }
            }
            res.add(tmp);
            return;
        }
        if(idx>=len || visited[idx]){
            return;
        }
        // 不要
        dfs(nums,visited,idx+1,cnt,sum,target);
        // 要
        int num = nums[idx];
        visited[idx] = true;
        dfs(nums,visited,idx+1,cnt+1,sum+num,target);
        visited[idx] = false;
    }

    public static void main(String[] args) {
//        int[] nums = {-2,0,1,1,2};
        int[] nums = {-40,-10,-10,0,10,20};
        ArrayList<ArrayList<Integer>> res = new BM54_2().threeSum(nums);
        System.out.println(res);
    }
}
