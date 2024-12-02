package cn.njust.leetcode.JZOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class JZ59 {

    // 滑动窗口的最大值
    public ArrayList<Integer> maxInWindows(int [] nums, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums.length==0 || size<1 || nums.length<size){
            return res;
        }
        // 单调递减队列  存放数组下标
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            int tmp = nums[i];
            while(!queue.isEmpty() && nums[queue.getLast()]<tmp){
                queue.removeLast();
            }
            queue.add(i);

            // 窗口之前的数据过期
            if(queue.getFirst()+size<=i){
                queue.removeFirst();
            }
            // 形成窗口  i是窗口的最右边
            if(i+1>=size){
                res.add(nums[queue.getFirst()]);
            }
        }
        return res;

    }

    public static void main(String[] args) {


    }
}
