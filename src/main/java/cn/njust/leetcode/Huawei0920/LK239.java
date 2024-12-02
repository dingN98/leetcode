package cn.njust.leetcode.Huawei0920;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayDeque;

public class LK239 {

    // 滑动窗口的最大值
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length-k+1];
        // 单调减队列  存放数组下标
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i=0;i<nums.length;i++){
            // 入队列
            int num = nums[i];
            while(!queue.isEmpty() && nums[queue.peekLast()]<num){
                queue.pollLast();
            }
            queue.add(i);
            // 左边伸缩
            while(!queue.isEmpty() && (queue.peekLast()-queue.peekFirst()+1)>k){
                queue.pollFirst();
            }
            if(i>=k-1){
                res[i-k+1] = nums[queue.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new LK239().maxSlidingWindow(nums,k);
        for(int tmp:res){
            System.out.print(tmp+" ");
        }
    }
}
