package cn.njust.leetcode.JZOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JZ40_2 {


    // 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。
    // 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。

    // 用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {5,4,3,2,1};
        int k = 3;
        System.out.println(new JZ40_2().GetLeastNumbers_Solution(nums,k));

    }
}
