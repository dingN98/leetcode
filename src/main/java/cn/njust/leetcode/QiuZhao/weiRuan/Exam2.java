package cn.njust.leetcode.QiuZhao.weiRuan;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Exam2 {

    int MOD = (int)Math.pow(10,9)+7;

    public int solution(int[] X, int[] Y) {
        int len = X.length;
        Map<BigDecimal,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            BigDecimal m = new BigDecimal((double)X[i]/(double)Y[i]);
            if(map.containsKey(m)){
                map.put(m,map.get(m)+1);
            }else{
                map.put(m,1);
            }
        }
        System.out.println(map);
        long res = 0;
        if(map.containsKey(new BigDecimal(0.5))){
            int m = map.get(new BigDecimal(0.5));
            res += m*(m-1)/2;
//            res %= MOD;
        }
        for(BigDecimal m:map.keySet()){
            if(m.equals(new BigDecimal(0.5))){
                continue;
            }
            BigDecimal sum = new BigDecimal(1.0);
            BigDecimal n = sum.subtract(m);
            if(map.containsKey(n)){
                res += map.get(m)*map.get(n);
//                res %= MOD;
            }
        }
        return (int)res;

    }

    public static void main(String[] args) {
        int[] X = {1,1,2};
        int[] Y = {3,2,3};
        int res = new Exam2().solution(X,Y);
        System.out.println(res);

    }
}
