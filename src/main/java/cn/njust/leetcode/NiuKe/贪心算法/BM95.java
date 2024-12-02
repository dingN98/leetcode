package cn.njust.leetcode.NiuKe.贪心算法;

public class BM95 {

    // BM95 分糖果问题
    // 一群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下：
    //
    //1. 每个孩子不管得分多少，起码分到一个糖果。
    //2. 任意两个相邻的孩子之间，得分较多的孩子必须拿多一些糖果。(若相同则无此限制)
    //
    //给定一个数组 arr 代表得分数组，请返回最少需要多少糖果。

    // 直接看题解  两次遍历  先从左向右 再从右向左


    public int candy (int[] arr) {
        // write code here
        int len = arr.length;

        int res = 0;

        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i] = 1;
        }

        // 先从左向右
        for(int i=1;i<len;i++){
            if(arr[i]>arr[i-1]){
                nums[i] = nums[i-1]+1;
            }
        }
        res += nums[len-1];

        // 再从右向左
        for(int i=len-1;i>0;i--){
            if(arr[i-1]>arr[i] && nums[i-1]<=nums[i]){
                nums[i-1] = nums[i]+1;
            }
            res += nums[i-1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};

        int res = new BM95().candy(arr);
        System.out.println(res);
    }
}
