package cn.njust.leetcode.QiuZhao.MicroSoft0825;

import java.util.HashMap;

public class Exam2_3 {

    public int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        HashMap<Integer,Long> dic = new HashMap<>();
        long res = 0;
        int prefix = 0;
        dic.put(0,1L);
        for(int num:A){
            prefix += num;
            if(dic.containsKey(prefix)){
                res += dic.get(prefix);
                dic.put(prefix,dic.get(prefix)+1);
            }else{
                dic.put(prefix,1L);
            }
            if(res>=1000000000){
                return -1;
            }
        }
        return (int)res;
    }

    public static void main(String[] args) {
//        int[] A = {2,-2,3,0,4,-7};
        int[] A = new int[100000];
        int res = new Exam2_3().solution(A);
        System.out.println(res);

    }
}
