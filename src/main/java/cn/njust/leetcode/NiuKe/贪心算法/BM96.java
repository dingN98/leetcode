package cn.njust.leetcode.NiuKe.贪心算法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BM96 {

    // BM96 主持人调度（二）
    // 有 n 个活动即将举办，每个活动都有开始时间与活动的结束时间，第 i 个活动的开始时间是 starti ,第 i 个活动的结束时间是 endi ,举办某个活动就需要为该活动准备一个活动主持人。
    // 一位活动主持人在同一时间只能参与一个活动。并且活动主持人需要全程参与活动，换句话说，一个主持人参与了第 i 个活动，那么该主持人在 (starti,endi) 这个时间段不能参与其他任何活动。求为了成功举办这 n 个活动，最少需要多少名主持人。

    // 有点难这题
    // 我直接看的题解，使用 排序+小根堆 实现
    // 小根堆主要存储 最近的一个活动的结束时间

    public int minmumNumberOfHost (int n, int[][] startEnd) {
        // write code here
        // 首先排序
        Arrays.sort(startEnd, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[1]-o2[0];
            }
        });

        // 堆排序
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(startEnd[0][1]);
        for(int i=1;i<startEnd.length;i++){
            if(startEnd[i][0]>=queue.peek()){
                // 区间没有重叠
                queue.poll();
            }
            queue.offer(startEnd[i][1]);
        }
        return queue.size();
    }


    public static void main(String[] args) {

    }
}
