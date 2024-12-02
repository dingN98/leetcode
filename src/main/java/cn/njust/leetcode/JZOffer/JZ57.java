package cn.njust.leetcode.JZOffer;

import java.util.ArrayList;

public class JZ57 {

    // 输入一个升序数组 array 和一个数字S，在数组中查找两个数，使得他们的和正好是S，
    // 如果有多对数字的和等于S，返回任意一组即可，如果无法找出这样的数字，返回一个空数组即可。

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array.length<=1){
            return res;
        }
        for(int left=0,right=array.length-1;left<right;){
            int sum2 = array[left]+array[right];
            if(sum==sum2){
                res.add(array[left]);
                res.add(array[right]);
                return res;
            }else if(sum2<sum){
                left++;
            }else{
                right--;
            }
        }
        return res;

    }

    public static void main(String[] args) {

        int[] nums = {1,4,4,9};
        int sum = 8;
        ArrayList<Integer> res = new JZ57().FindNumbersWithSum(nums,sum);
        System.out.println(res);

    }
}
