package cn.njust.leetcode.JZOffer;

import java.util.HashMap;
import java.util.HashSet;

public class JZ61 {

    //  5张扑克牌能否组成顺子
    public boolean IsContinuous(int [] nums) {
        // 思路是找到连续数字
        int zeros = 0;
        int minV = Integer.MAX_VALUE;
        int maxV = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            int tmp = nums[i];
            if(tmp==0){
                zeros++;
                continue;
            }
            if(set.contains(tmp)){
                return false;
            }else{
                set.add(tmp);
            }
            minV = Math.min(minV,tmp);
            maxV = Math.max(maxV,tmp);
        }

        if((maxV-minV+1)>5){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

//        int[] nums = {6,0,2,0,4};
//        int[] nums = {0,3,2,6,4};
        int[] nums = {1,0,0,1,0};
        boolean res = new JZ61().IsContinuous(nums);
        System.out.println(res);


    }
}
