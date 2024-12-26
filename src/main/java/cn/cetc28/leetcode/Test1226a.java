package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/26 20:05
 * 084 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 */
public class Test1226a {

    public int largestRectangleArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        int minValue = calMinValue(heights,left,right);
        while(left<=right){

            maxArea = Math.max(maxArea,minValue*(right-left+1));
            if(heights[left]<=heights[right]){
                if(heights[left]==minValue){
                    minValue = calMinValue(heights,left+1,right);
                }
                left++;
            }else if(heights[left]>heights[right]){
                if(heights[right]==minValue){
                    minValue = calMinValue(heights,left,right-1);
                }
                right--;
            }
        }
        return maxArea;
    }

    public int calMinValue(int[] nums, int left, int right){
        int minValue = Integer.MAX_VALUE;
        for(int i=left;i<=right;i++){
            minValue = Math.min(minValue,nums[i]);
        }
        return minValue;
    }

    public static void main(String[] args) {

        Test1226a t = new Test1226a();
        int[] heights = {5,5,1,7,1,1,5,2,7,6};
        System.out.println(t.largestRectangleArea(heights));


    }
}
