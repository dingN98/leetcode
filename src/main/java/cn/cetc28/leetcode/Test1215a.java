package cn.cetc28.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/15 10:37
 * 046 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Test1215a {

    public void fun(int[] nums,boolean[] visited,List<Integer> path,List<List<Integer>> res){
        int len = nums.length;
        int count = 0;
        for(int i=0;i<len;i++){
            if(visited[i]){
                count++;
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            fun(nums,visited,path,res);
            path.remove(path.size()-1);
            visited[i] = false;
        }
        if(count==len){
            res.add(new ArrayList<>(path));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        fun(nums,visited,path,res);
        return res;

    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        Test1215a t = new Test1215a();
        System.out.println(t.permute(nums));

    }
}
