package cn.njust.leetcode.QiuZhao.weiRuan;

import java.util.HashMap;
import java.util.Map;

public class Exam2_4 {

    int MOD = (int)Math.pow(10,9)+7;

    public int solution(int[] X, int[] Y) {
        int len = X.length;
        Map<Double,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            Double m = X[i]/(double)Y[i];
            if(map.containsKey(m)){
                map.put(m,map.get(m)+1);
            }else{
                map.put(m,1);
            }
        }
//        System.out.println(map);
        long res = 0;
        if(map.containsKey(0.5)){
            int m = map.get(0.5);
            res += m*(m-1)/2;
            res %= MOD;
        }
        for(Double m:map.keySet()){
            if(m.equals(0.5)){
                continue;
            }
            Double sum = 1.0;
            Double n = sum-m;
            for(Double key:map.keySet()){
                if(Math.abs(key-n)<0.001){
                    res += map.get(m)*map.get(key);
                    res %= MOD;
                }
            }
        }
        return (int)res;

    }

    public static void main(String[] args) {
        int[] X = {1,1,2};
        int[] Y = {3,2,3};
        int res = new Exam2_4().solution(X,Y);
        System.out.println(res);

    }
}
