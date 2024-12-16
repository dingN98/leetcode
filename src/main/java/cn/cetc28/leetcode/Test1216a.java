package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/16 20:33
 * 055 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class Test1216a {

    // 看题解，贪心算法，记录最远可以到达的下标:maxIdx
    public boolean canJumpModified(int[] nums){
        if(nums.length<=1){
            return true;
        }
        int maxIdx = nums[0];
        int len = nums.length;
        for(int i=1;i<len;i++){
            if(i>maxIdx){
                return false;
            }
            maxIdx = Math.max(maxIdx,i+nums[i]);
        }
        return true;
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        for(int i=1;i<len;i++){
            boolean flag = false;
            for(int j=0;j<i;j++){
                if((j+nums[j])>=i){
                    flag = true;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;

        // (i-1)+nums[i-1]>=1 || (i-2)+nums[i-2]>=2 ||...|| (i-n)+nums[i-n]>=n
        //


    }

    public static void main(String[] args) {

        Test1216a t = new Test1216a();
        int[] nums = {2,3,1,1,4};
        System.out.println(t.canJump(nums));

    }


}
