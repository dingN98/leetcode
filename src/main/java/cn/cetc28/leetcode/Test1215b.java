package cn.cetc28.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/15 10:49
 */
public class Test1215b {
    public void fun(int[] nums,boolean[] visited,List<Integer> path,List<List<Integer>> res){
        int len = nums.length;
        // 先排序
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(nums[i]>nums[j]){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        int count = 0;
        for(int i=0;i<len;i++){
            if(visited[i]){
                count++;
                continue;
            }
            // 值得注意的是  下面这个判断语句决定了剪枝的思路
            // 如果是  ！visited[i-1]  那就是 同层剪枝，
            // 我个人觉得像深度搜索，同一层的多个重复元素，只有第一个会在本层去访问，其余的在下层下下层去访问   力扣耗时 1ms
            // 如果是  visited[i-1]   那就是 非同层剪枝，我个人觉得像广度搜索    力扣耗时 4ms
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]){
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

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        fun(nums,visited,path,res);
        return res;

    }

    public static void main(String[] args) {

        int[] nums = {1,2,1};
        Test1215b t = new Test1215b();
        System.out.println(t.permuteUnique(nums));

    }
}
