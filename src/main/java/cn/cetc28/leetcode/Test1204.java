package cn.cetc28.leetcode;

import sun.plugin.dom.html.ns4.NS4DOMObject;

import javax.smartcardio.ATR;
import javax.swing.*;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/4 19:22
 * 016 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 */
public class Test1204 {

    public static void main(String[] args) {
        Test1204 t = new Test1204();
        int[] nums = {1,1,1,0};
        int target = 100;
        System.out.println(t.threeSumClosest(nums,target));;

    }

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        // 先排序
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(nums[i]>nums[j]){
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        if(len<=2){
            return 0;
        }
        int similar = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0;i<len;i++){
            // 固定a，b和c位于数组i+1和最右边，然后开始对比，移动
            int left = i+1;
            int right = len-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==target){
                    return target;
                }
                if(Math.abs(sum-target)<Math.abs(similar - target)){
                    similar = sum;
                }
                if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
//            for(int j=i+1;j<len;j++){
//                for(int k=j+1;k<len;k++){
//                    int sum = nums[i]+nums[j]+nums[k];
//                    if(Math.abs(sum-target)<Math.abs(similar -target)){
//                        similar = sum;
//                    }else{
//                        break;
//                    }
//                }
//            }
        }
        return similar;

    }
}
