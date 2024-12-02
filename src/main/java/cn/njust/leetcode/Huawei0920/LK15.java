package cn.njust.leetcode.Huawei0920;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LK15 {

    // 15. 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<len;i++){
            // 去重
            if(i-1>=0 && nums[i]==nums[i-1]){
                continue;
            }
            int yuShu = -nums[i];
            int left = i+1;
            int right = len-1;
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum==yuShu){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    // 去重
                    while((left+1)<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while((right-1)>left && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                }if(sum<yuShu){
                    left++;
                }else{
                    right--;
                }

            }
        }
        return res;

    }

    public static void main(String[] args) {

//        int[] nums = {0,0,0,0,0};
        int[] nums = {-2,0,1,1,2};
//        int[] nums = {-4,-1,-1,0,1,2};
        List<List<Integer>> res = new LK15().threeSum(nums);
        System.out.println(res);

    }
}
