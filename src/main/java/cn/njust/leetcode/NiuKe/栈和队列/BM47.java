package cn.njust.leetcode.NiuKe.栈和队列;

import java.util.PriorityQueue;

public class BM47 {

    // BM47 寻找第K大
    public int findKth(int[] a, int n, int K) {
        // write code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            int tmp = a[i];
            if(minHeap.size()<K){
                minHeap.add(tmp);
            }else{
                if(!minHeap.isEmpty() && tmp>minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(tmp);
                }
            }
        }
        return !minHeap.isEmpty()?minHeap.peek():0;
    }

    public static void main(String[] args) {

    }
}
