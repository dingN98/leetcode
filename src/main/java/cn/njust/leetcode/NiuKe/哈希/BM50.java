package cn.njust.leetcode.NiuKe.哈希;

import java.util.HashMap;

public class BM50 {

    // BM50 两数之和
    // 方法一  哈希 拿空间换时间
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] res = new int[2];
        // 余数  下标
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            if(map.containsKey(target-num)){
                res[0] =  map.get(target-num)+1;
                res[1] = i+1;
                return res;
            }else{
                map.put(num,i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] res = new BM50().twoSum(nums,target);
        for(int tmp:res){
            System.out.println(tmp);
        }


    }
}
