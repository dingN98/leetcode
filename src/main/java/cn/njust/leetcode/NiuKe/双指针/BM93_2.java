package cn.njust.leetcode.NiuKe.双指针;

public class BM93_2 {

    // BM93 盛水最多的容器  中等题
    // 给定一个数组height，长度为n，每个数代表坐标轴中的一个点的高度，height[i]是在第i点的高度，请问，从中选2个高度与x轴组成的容器最多能容纳多少水
    //1.你不能倾斜容器
    //2.当n小于2时，视为不能形成容器，请返回0
    //3.数据保证能容纳最多的水不会超过整形范围，即不会超过231-1


    // 方法2  双指针  消耗时间是 双重暴力循环的   1/10


    public int maxArea (int[] height) {
        // write code here
        int res = 0;
        int len = height.length;

        int left = 0,right = len-1;
        while(left<right){
            int tmp = (right-left)*Math.min(height[left],height[right]);
            res = Math.max(res,tmp);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }

        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1,7,3,2,4,5,8,2,7};
        int res = new BM93_2().maxArea(nums);
        System.out.println(res);

    }
}
