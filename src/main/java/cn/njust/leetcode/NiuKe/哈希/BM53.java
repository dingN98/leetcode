package cn.njust.leetcode.NiuKe.哈希;

import java.util.HashMap;

public class BM53 {

    // BM53 缺失的第一个正整数
    public int minNumberDisappeared (int[] nums) {
        // write code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxV = 0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            map.put(num,1);
            maxV = Math.max(maxV,num);
        }
        for(int i=1;i<=maxV+1;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {-2,3,4,1,5};
//        int[] nums = {4,5,6,8,9};
        int res = new BM53().minNumberDisappeared(nums);
        System.out.println(res);


    }
}
