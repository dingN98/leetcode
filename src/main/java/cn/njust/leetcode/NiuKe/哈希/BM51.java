package cn.njust.leetcode.NiuKe.哈希;

import cn.njust.leetcode.NiuKe.贪心算法.BM95;

import java.util.HashMap;

public class BM51 {

    // BM51 数组中出现次数超过一半的数字
    // 使用Hash Map  空间复杂度是  O(n)
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = array.length;
        int[] nums = array;
        for(int i=0;i<len;i++){
            int num = nums[i];
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
            if(map.get(num)>len/2){
                return num;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,5,4,2};
        int res = new BM51().MoreThanHalfNum_Solution(nums);
        System.out.println(res);

    }
}
