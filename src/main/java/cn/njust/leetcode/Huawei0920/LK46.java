package cn.njust.leetcode.Huawei0920;

import java.util.ArrayList;
import java.util.List;

public class LK46 {

    List<List<Integer>> res =new ArrayList<>();

    // 全排列
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            dfs(nums,new boolean[nums.length],i,0,new ArrayList<>());
        }
        return res;
    }

    public void dfs(int[] nums,boolean[] visited,int idx,int cnt,ArrayList<Integer> path){
        int len = nums.length;
//        System.out.println("cnt:"+cnt);
        if(cnt==len-1){
            path.add(nums[idx]);
            res.add(new ArrayList<>(path));
            return;
        }

        int num = nums[idx];
        visited[idx] = true;
        path.add(num);
        for(int i=0;i<len;i++){
            if(!visited[i]){
                dfs(nums,visited,i,cnt+1,path);
            }
        }
        path.remove(path.size()-1);
        visited[idx] = false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new LK46().permute(nums);
        System.out.println(res);
    }
}
