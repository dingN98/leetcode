package cn.cetc28.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/3 23:11
 * 015 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class Test1203d {

    public static void main(String[] args) {
        Test1203d t = new Test1203d();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(t.threeSum(nums));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        // [-2,-1,0,1,1,2]
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int num3 = -nums[i] - nums[j];
                if(map.containsKey(num3)){
                    if(map.get(num3)!=i && map.get(num3)!=j && map.get(num3)>j){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(num3);
                        tmp.sort((o1, o2) -> o1-o2);
                        if(!res.contains(tmp)){
                            res.add(tmp);
                        }
                    }

                }
            }
        }
        return res;

    }
}
