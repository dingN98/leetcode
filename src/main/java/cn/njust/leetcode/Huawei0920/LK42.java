package cn.njust.leetcode.Huawei0920;

public class LK42 {

    // 42. 接雨水
    public int trap(int[] height) {
        int len = height.length;
        int maxLeft = 0;
        int maxRight=  0;
        int left = 0;
        int right = len-1;
        int res = 0;

        while(left<right){
            maxLeft = Math.max(maxLeft,height[left]);
            maxRight = Math.max(maxRight,height[right]);
            if(maxLeft<maxRight){
                res += (maxLeft-height[left]);
                left++;
            }else{
                res += (maxRight-height[right]);
                right--;
            }
        }
        return res;

    }

}
