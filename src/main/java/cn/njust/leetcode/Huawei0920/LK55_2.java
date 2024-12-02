package cn.njust.leetcode.Huawei0920;

public class LK55_2 {

    // 55 跳跃游戏
    public boolean canJump(int[] nums) {


        // 第二版 看高赞答案
        // 每走一步  看剩余的能量和这个格子的能量取一个最大值
        int power = nums[0];
        for(int i=1;i<nums.length;i++){
            power--;
            if(power<0){
                return false;
            }
            power = Math.max(power,nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
