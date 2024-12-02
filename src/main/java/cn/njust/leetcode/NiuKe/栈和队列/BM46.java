package cn.njust.leetcode.NiuKe.栈和队列;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BM46 {

    // 最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int tmp:input){
            queue.add(tmp);
        }
        for(int i=0;i<k;i++){
            res.add(queue.poll());
        }
        return res;

    }

    public static void main(String[] args) {

        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> res = new BM46().GetLeastNumbers_Solution(input,k);
        System.out.println(res);

    }

}
