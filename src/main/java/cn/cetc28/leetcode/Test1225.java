package cn.cetc28.leetcode;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/25 22:51
 * 081 搜索旋转排序数组II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * 你必须尽可能减少整个操作步骤。
 *
 * 示例 1：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 */
public class Test1225 {

    public boolean search(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.contains(num)){
                set.add(num);
                list.add(num);
            }
        }
        nums = list.stream().mapToInt(Integer::intValue).toArray();
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            if(target==nums[left]||target==nums[right]||target==nums[mid]){
                return true;
            }
            if(nums[left]<nums[right]){
                if(target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[left]<nums[mid]){
                    if(target>nums[left] && target<nums[mid]){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }else{
                    if(target>nums[mid]&&target<nums[right]){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }
            }
        }
        return false;



    }

    public static void main(String[] args) {

    }
}
