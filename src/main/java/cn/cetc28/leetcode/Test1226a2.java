package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/26 20:24
 * 084 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 *
 * 超时，通过89/99
 *
 */
public class Test1226a2 {

    public int largestRectangleArea(int[] heights){

        int len = heights.length;

        int left = 0;
        int right = 0;
        int maxArea = 0;
        int minValue = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0;i<heights.length;i++){
            // 以heights[i]为初始位置开始向两边扩充，一旦最大面积减小，while循环结束。
            left = right = i;
            minValue = heights[left];
            maxArea = (right-left+1)*minValue;
            while (true){
                if(left-1>=0 && right+1<len){
                    if(heights[left-1]<=heights[right+1]){
                        // 向右边扩
                        right++;
                        minValue = Math.min(minValue,heights[right]);
                    }else{
                        // 向左边扩
                        left--;
                        minValue = Math.min(minValue,heights[left]);
                    }
                }else if(left-1>=0){
                    left--;
                    minValue = Math.min(minValue,heights[left]);
                }else if(right+1<len){
                    right++;
                    minValue = Math.min(minValue,heights[right]);
                }else{
                    break;
                }
                int area = (right-left+1)*minValue;
                if(area>=maxArea){
                    maxArea = area;
                }else{
                    break;
                }
            }
            res = Math.max(res,maxArea);
        }
        return res;

    }

    public static void main(String[] args) {

        Test1226a2 t = new Test1226a2();
        int[] heights = {5,5,1,7,1,1,5,2,7,6};
        System.out.println(t.largestRectangleArea(heights));

    }
}
