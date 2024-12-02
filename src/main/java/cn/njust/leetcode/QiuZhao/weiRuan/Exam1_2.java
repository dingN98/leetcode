package cn.njust.leetcode.QiuZhao.weiRuan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Exam1_2 {



    public int solution(int[] A) {

        int cnt = 0;
        PriorityQueue<Double> q = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1<o2){
                    return 1;
                }else if(o1>o2){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        double sumTmp = 0;
        for(int i=0;i<A.length;i++){
            sumTmp += A[i];
            q.add((double)A[i]);
        }
        double target = sumTmp/2.0;
        while(sumTmp>target){
            double a = q.poll();
            q.add(a/2.0);
            cnt++;
            sumTmp -= a/2.0;
        }

        return cnt;

    }




    public static void main(String[] args) {

        int[] nums = {5,19,8,1};
//        int[] nums = {10,10};
//        int[] nums = {3,0,5};
        int res = new Exam1_2().solution(nums);
        System.out.println(res);



    }
}
