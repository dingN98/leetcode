package cn.njust.leetcode.NiuKe.双指针;

import java.util.HashSet;

public class BM92 {

    // BM92 最长无重复子数组   中等
    // 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
    // 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组

    // 方法一：暴力

    public int maxLength (int[] nums) {
        // write code here
        int len = nums.length;

        int res = 0;

        for(int i=0;i<len;i++){
            HashSet<Integer> set = new HashSet<>();
            int maxLen = 0;
            for(int j=i;j<len;j++){
                int tmp = nums[j];
                if(!set.contains(tmp)){
                    set.add(tmp);
                    maxLen++;
                }else{
                    break;
                }
            }
            res = Math.max(res,maxLen);
        }
        return res;

    }

    public static void main(String[] args) {

//        int[] nums = {2,2,3,4,3};
        int[] nums = {2,3,4,5};
        int res = new BM92().maxLength(nums);
        System.out.println(res);

    }
}
