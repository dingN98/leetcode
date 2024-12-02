package cn.njust.leetcode.Huawei0920;

public class LK004 {

    // 1004. 最大连续1的个数 III
    // 滑动窗口
    public int longestOnes(int[] nums, int k) {
        int cnt = 0;
        int left = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                // 吃掉一个0
                cnt++;
            }
            if(cnt>k){
                // 释放一个0
                while(nums[left]==1){
                    left++;
                }
                left++;
                cnt--;
            }
            res = Math.max(res,i-left+1);
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
