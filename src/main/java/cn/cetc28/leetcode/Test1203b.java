package cn.cetc28.leetcode;

import javax.lang.model.type.ErrorType;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/3 21:19
 * 011 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 */
public class Test1203b {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        Test1203b t = new Test1203b();
        System.out.println(t.maxArea2(height));
    }

    public int maxArea2(int[] height){
        int len = height.length;
        if(len<=1){
            return 0;
        }
        int left=0,right = len-1;
        int maxWater = 0;
        while(left<right){
            maxWater = Math.max(maxWater,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }

    // 暴力会超时
    // 因为第二层循环没有意义，
    // 假设 height[i]<height[j],0<i<j<len
    // 在i指针固定之后，无论j指针怎么移动，容器最大容量都不会超过（len-i-1）*height(i)
    public int maxArea(int[] height) {
        int len = height.length;
        if(len<=1){
            return 0;
        }
        int maxWater = 0;

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                maxWater = Math.max(maxWater,(j-i)*Math.min(height[i],height[j]));
//                System.out.println("["+i+","+j+"]之前的容器容量为="
//                        +(j-i)*Math.min(height[i],height[j])
//                        +"，不超过"+(len-i-1)*height[i]);
            }
        }
        return maxWater;
    }
}
