package cn.njust.leetcode.QiuZhao.DaJiang;

public class Exam1 {

    public boolean containsNearbyDuplic(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j] && (j-i)<=k){
                    return true;
                }
            }
        }
        return false;

    }
    public static void main(String[] args) {
        // nums=[1,2,3,1],k=3
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(new Exam1().containsNearbyDuplic(nums,k));
    }
}
