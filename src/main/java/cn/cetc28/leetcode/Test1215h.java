package cn.cetc28.leetcode;

import java.util.Arrays;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/15 19:23
 * 053 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 */
public class Test1215h {

    public int maxSubArray(int[] nums) {

        int len = nums.length;
        // dp[i]代表以nums[i]结尾的[x,i]区间最大值
        int[] dp = new int[len];
        int res = nums[0];
        dp[0] = nums[0];
        for(int i=1;i<len;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;


//        int sum = Arrays.stream(nums).sum();
//        int sumMax = sum;
//        int left = 0;
//        int right = nums.length-1;
//        while(left<right){
//            if(nums[left]==nums[right]){
//                int tmpLeft = left+1;
//                int tmpRight = right-1;
//                while(tmpLeft<tmpRight){
//                    if(nums[tmpLeft]==nums[tmpRight]){
//                        tmpLeft++;
//                        tmpRight--;
//                    }else if(nums[tmpLeft]<nums[tmpRight]){
//                        sum-=nums[left];
//                        sumMax = Math.max(sumMax,sum);
//                        left++;
//                        break;
//                    }else{
//                        sum-=nums[right];
//                        sumMax = Math.max(sumMax,sum);
//                        right--;
//                        break;
//                    }
//                }
//                if(tmpLeft==tmpRight){
//                    sum-=nums[left];
//                    sumMax = Math.max(sumMax,sum);
//                    left++;
//                }
//
//
//            }else if(nums[left]<nums[right]){
//                sum-=nums[left];
//                sumMax = Math.max(sumMax,sum);
//                left++;
//            }else{
//                sum-=nums[right];
//                sumMax = Math.max(sumMax,sum);
//                right--;
//            }
//        }
//        return sumMax;

    }


    public static void main(String[] args) {

        Test1215h t = new Test1215h();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(t.maxSubArray(nums));

    }
}
