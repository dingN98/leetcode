package cn.cetc28.leetcode;

import javax.lang.model.type.ErrorType;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/10 20:43
 * 035 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class Test1210 {

    public static void main(String[] args) {

        Test1210 t = new Test1210();
        int[] nums = {1,3,5,6};
        int target = 7;
        int res = t.searchInsert(nums, target);
        System.out.println(res);

    }

    public int searchInsert(int[] nums, int target) {

//        if(nums.length==0){
//            return 0;
//        }
//        if(target>nums[nums.length-1]){
//            return nums.length;
//        }

        int len = nums.length;
        int left = 0;
        int right = len-1;
        int mid = 0;
        int ans = len;
        while(left<=right){
            mid = (left+right)/2;
            if(target<=nums[mid]){
                // 無限逼近target的nums[ans]
                ans = mid;
                right = mid-1;

            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}
