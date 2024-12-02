package cn.cetc28.leetcode;

import sun.plugin.dom.html.ns4.NS4DOMObject;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.util.HashMap;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/1 17:39
 * 001 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 */
public class Test1201 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] res = twoSum(nums,9);
        System.out.println("["+res[0]+","+res[1]+"]");

    }


    public static int[] twoSum(int[] nums, int target) {

        // 方法一：暴力枚举   时间复杂度  O(N2），空间复杂度 O(1)
//        int len = nums.length;
//        for(int i=0;i<len;i++){
//            for(int j=i+1;j<len;j++){
//                if(nums[i]+nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[0];

        // 方法二  哈希 时间复杂度  O（N），空间复杂度  O（N)
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>(len);
        for (int i=0;i<len;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }
}
