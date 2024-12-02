package cn.njust.leetcode.NiuKe.哈希;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

import java.util.Arrays;
import java.util.HashMap;

public class BM50_2 {

    // BM50 两数之和
    // 方法二  双指针 拿时间换空间
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int len = numbers.length;
        int[] res = new int[2];
        // 余数  下标
        Arrays.sort(numbers);
        int left = 0,right = len-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum == target){
                res[0] = left;
                res[1] = right;
                return res;
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
        int[] nums = {3,2,4};
        int target = 6;
        int[] res = new BM50_2().twoSum(nums,target);
        for(int tmp:res){
            System.out.println(tmp);
        }


    }
}
