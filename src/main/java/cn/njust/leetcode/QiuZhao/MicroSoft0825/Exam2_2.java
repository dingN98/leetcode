package cn.njust.leetcode.QiuZhao.MicroSoft0825;

import java.util.HashMap;

public class Exam2_2 {

    public int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        int len = A.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for(int i=0;i<len;i++){
            sum += A[i];
            res += map.getOrDefault(sum,0);
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] A = {2,-2,3,0,4,-7};
        int[] A = {0,0,0,0,0};
        int res = new Exam2_2().solution(A);
        System.out.println(res);

    }
}
