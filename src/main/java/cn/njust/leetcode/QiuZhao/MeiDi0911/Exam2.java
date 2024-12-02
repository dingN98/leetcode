package cn.njust.leetcode.QiuZhao.MeiDi0911;

import java.util.ArrayList;

public class Exam2 {

    public boolean isPrime(int n){
        if(n==1 || n==0){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }


    public ArrayList<Integer> findPrimeNumber (int m, int n) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=m;i<=n;i++){
            if(isPrime(i)){
                res.add(i);
            }
        }
        return res;
    }


}
