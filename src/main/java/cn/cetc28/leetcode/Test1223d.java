package cn.cetc28.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/23 20:58
 * 078 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集
 * （幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Test1223d {

    public void fun(int[] nums,int idx,List<Integer> path,List<List<Integer>> res){
        res.add(new ArrayList<>(path));
        for(int i=idx+1;i<nums.length;i++){
            path.add(nums[i]);
            fun(nums,i,path,res);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        fun(nums,-1,new ArrayList<>(),res);
        return res;
    }

    public static void main(String[] args) {

        Test1223d t = new Test1223d();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(t.subsets(nums));

    }
}
