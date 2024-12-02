package cn.njust.leetcode.NiuKe.双指针;

import java.util.HashSet;

public class BM92_2 {

    // BM92 最长无重复子数组   中等
    // 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
    // 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组

    // 方法2:双指针。单重循环  同时，删除集合里的重复元素（包含该元素之前的元素）   运行时间时前一个双重循环的  1/3
    // if(set.contains(tmp)){
    //                set.remove(left++);
    //            }

    public int maxLength (int[] nums) {
        // write code here
        int len = nums.length;

        int res = 0;
        int left = 0,right = 0;
        HashSet<Integer> set = new HashSet<>();

        while(right<len){
            int tmp = nums[right];
            if(set.contains(tmp)){
                set.remove(nums[left++]);
            }else{
                set.add(tmp);
                right++;
                res = Math.max(res,set.size());
            }
        }
        return res;

    }

    public static void main(String[] args) {

        int[] nums = {2,2,3,4,3};
//        int[] nums = {2,3,4,5};
        int res = new BM92_2().maxLength(nums);
        System.out.println(res);

    }
}
