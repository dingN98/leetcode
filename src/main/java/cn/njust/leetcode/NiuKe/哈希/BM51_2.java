package cn.njust.leetcode.NiuKe.哈希;

import java.util.HashMap;

public class BM51_2 {

    // BM51 数组中出现次数超过一半的数字
    // 使用Hash Map  空间复杂度是  O(n)
    public int MoreThanHalfNum_Solution(int [] array) {
        int cnt = 0;
        int numTmp = 0;
        int len = array.length;
        for(int i=0;i<len;i++){
            int num = array[i];
            if(cnt==0){
                cnt = 1;
                numTmp = num;
                continue;
            }
            if(num==numTmp){
                cnt++;
            }else{
                cnt--;
            }
        }
        return numTmp;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,5,4,2};
        int res = new BM51_2().MoreThanHalfNum_Solution(nums);
        System.out.println(res);

    }
}
