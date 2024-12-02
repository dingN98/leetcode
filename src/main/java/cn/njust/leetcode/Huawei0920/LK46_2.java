package cn.njust.leetcode.Huawei0920;

import java.util.ArrayList;
import java.util.List;

public class LK46_2 {

    List<List<Integer>> res =new ArrayList<>();

    // 全排列
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,new boolean[nums.length],new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums,boolean[] visited,ArrayList<Integer> path){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(visited[i]){
                continue;
            }
            int num = nums[i];
            visited[i] = true;
            path.add(num);
            dfs(nums,visited,path);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new LK46_2().permute(nums);
        System.out.println(res);
    }
}
