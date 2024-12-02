package cn.njust.leetcode.NiuKe.栈和队列;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BM48 {

    // BM48 数据流中的中位数
    // 这里有很多方法
    // 其中一个是使用俩堆  大顶堆存放较小的那一半  小顶堆存放较大的那一半

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void Insert(Integer num) {

        if(maxHeap.isEmpty() || minHeap.isEmpty()){
            if(maxHeap.isEmpty()){
                maxHeap.add(num);
            }else{
                if(num>=maxHeap.peek()){
                    minHeap.add(num);
                }else{
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                }
            }
            return;
        }

        int size = maxHeap.size()+minHeap.size();
        if(size%2==0){
            if(num<minHeap.peek()){
                maxHeap.add(num);
            }else{
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
        }else{
            if(num>maxHeap.peek()){
                minHeap.add(num);
            }else{
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        }

    }

    public Double GetMedian() {
        if((maxHeap.size()+minHeap.size())%2==1){
            return (double)maxHeap.peek();
        }else{
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }

    }


    public static void main(String[] args) {

    }
}
