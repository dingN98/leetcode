package cn.njust.leetcode.NiuKe.哈希;

import java.util.*;

public class BM54_4_双指针_2 {

    // 三数之和
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        HashSet<String> set = new HashSet<>();
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<len;i++){
            // 去重 不要重复计算 target
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            ArrayList<ArrayList<Integer>> tmp = twoSum(nums,i);
            res.addAll(tmp);
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> twoSum (int[] numbers, int idx) {
        // write code here
        int len = numbers.length;
        int target = -numbers[idx];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // 双指针
        int left = idx+1;
        int right = len-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum == target){
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(numbers[idx]);
                tmp.add(numbers[left]);
                tmp.add(numbers[right]);
                res.add(tmp);
                // 去重  s=a+b  不需要一样的a和b
                while((1+left)<right && numbers[left]==numbers[left+1]){
                    left++;
                }
                while(left<(right-1) && numbers[right-1]==numbers[right]){
                    right--;
                }
            }
            if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-2,0,1,1,2};
        int[] nums = {-40,-10,-10,-10,-10,-10,0,10,10,10,10,20,20,20};
        ArrayList<ArrayList<Integer>> res = new BM54_4_双指针_2().threeSum(nums);
        System.out.println(res);
    }
}
