package cn.njust.leetcode.NiuKe.栈和队列;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BM46_2 {

    // 最小的k个数
    // 看题解  方案2  使用最大堆去保存最小的k个数   栈顶元素是这k个数里最大的

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        ArrayList<Integer> res = new ArrayList<>();
        for(int tmp:input){
            if(maxHeap.size()<k){
                maxHeap.add(tmp);
            }else{
                if(!maxHeap.isEmpty() && tmp<maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.add(tmp);
                }
            }
        }
        for(int i=0;i<k;i++){
            res.add(maxHeap.poll());
        }
        return res;

    }

    public static void main(String[] args) {

        int[] input = {4,5,1,6,2,7,3,8};
//        int[] input = {4,5,1,6,2,7,3,8};
        int k = 0;
        ArrayList<Integer> res = new BM46_2().GetLeastNumbers_Solution(input,k);
        System.out.println(res);

    }

}
