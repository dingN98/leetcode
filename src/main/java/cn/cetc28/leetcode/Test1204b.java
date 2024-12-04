package cn.cetc28.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/4 21:18
 * 018 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 */
public class Test1204b {

    public static void main(String[] args) {
        Test1204b t = new Test1204b();
//        int[] nums = {1,0,-1,0,-2,2};
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> res = t.fourSum(nums,target);
        System.out.println(res);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 先排序
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(nums[i]>nums[j]){
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        //双指针法  时间复杂度为O(N3)  空间复杂度为
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int left = j+1;
                int right = len-1;
                while (left<right){
                    long sum = (long)nums[i]+(long)nums[j]+(long)nums[left]+(long)nums[right];
                    if(sum==target){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        if(!res.contains(tmp)){
                            res.add(tmp);
                        }
                        // 可能还有解
                        left++;
                    }else if(sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }

            }
        }
        return res;

    }
}
