package cn.njust.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Exam1 {

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                // 就是  x^2+y^2  点到原点的距离公式
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }



    public int fun(int[] nums,int target){
        Arrays.sort(nums);

        int res = 0;
        int resAbs = Integer.MAX_VALUE;

        int len = nums.length;
        for(int i=0;i<len;i++){
            int t2 = target-nums[i];
            int left = i+1;
            int right = len-1;
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum == t2){
                    return target;
                }
                int tmp = nums[i]+sum;
                if(Math.abs(tmp-target)<resAbs){
                    resAbs = Math.abs(tmp-target);
                    res = tmp;
                }
                if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int res = new Exam1().fun(nums,target);
        System.out.println(res);
    }


}
