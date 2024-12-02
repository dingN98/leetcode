package cn.njust.leetcode.NiuKe.双指针;

public class BM94 {

    // 接雨水  难
    // 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个柱子高度图，计算按此排列的柱子，下雨之后能接多少雨水。(数组以外的区域高度视为0)

    public long maxWater (int[] arr) {
        // write code here
        // 双指针  从两边网中间靠近 用桶边去减去底的高度  碰到更高的桶边 更新


        int len = arr.length;
        int left = 0,right = len-1;
        int maxL = 0,maxR = 0;
        int res = 0;
        while(left<right){
            maxL = Math.max(maxL,arr[left]);
            maxR = Math.max(maxR,arr[right]);
            if(maxL<maxR){
                res += maxL-arr[left++];
            }else{
                res += maxR-arr[right--];
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
