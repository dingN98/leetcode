package cn.njust.leetcode.QiuZhao.XiaoHongShu0904;

import java.util.Arrays;
import java.util.Scanner;

public class Exam2_2 {

    public static int fun(int[] A){
        int fu = 0,zero = 0,zheng = 0;
        int n = A.length;
        for(int i=0;i<n;i++){
            if(A[i]<0){
                fu++;
            }else if(A[i]==0){
                zero++;
            }else{
                zheng++;
            }
        }
        Arrays.sort(A);
        int out = Integer.MAX_VALUE;
        if(zheng==0){
            int res = 0;
            res += Math.abs(A[0]-(-7));
            for(int i=1;i<n;i++){
                res += Math.abs(A[i]-(-1));
            }
            return res;
        }
        if(fu==0){
            int res = 0;
            for(int i=0;i<n-1;i++){
                res += Math.abs(A[i]-1);
            }
            res+=Math.abs(A[n-1]-7);
            return res;
        }
        if(fu%2==0){
            int res = 0;
            for(int i=0;i<fu;i++){
                res += (-1)-A[i];
            }
            for(int i=0;i<zero;i++){
                res +=1;
            }
            for(int i=0;i<zheng-1;i++){
                res += A[fu+zero+i]-1;
            }
            res += Math.abs(7-A[n-1]);
            out = Math.min(out,res);
            res = 0;
            res += Math.abs(A[0]-(-7));
            for(int i=1;i<fu;i++){
                res += (-1)-A[i];
            }
            for(int i=0;i<zero;i++){
                res+=1;
            }
            for(int i=0;i<zheng;i++){
                res += A[fu+zero+i]-1;
            }
            out = Math.min(out,res);

        }else{
            int res = 0;
            for(int i=0;i<fu;i++){
                res += (-1)-A[i];
            }
            if(zero>0){
                for(int i=0;i<zero;i++){
                    res += 1;
                }
                for(int i=0;i<zheng-1;i++){
                    res += A[fu+zheng+i]-1;
                }
                res+=Math.abs(7-A[n-1]);
            }else{
                res += A[fu+zheng]-(-1);
                for(int i=1;i<zheng-2;i++){
                    res += A[fu+zheng+i]-1;
                }
                res += Math.abs(7-A[n-1]);
            }
            out = Math.min(out,res);
            res= 0;
            res += Math.abs(A[0]-(-7));
            for(int i=1;i<fu;i++){
                res +=(-1)-A[i];
            }
            for(int i=0;i<zero;i++){
                res += 1;
            }
            for(int i=0;i<zheng;i++){
                res += A[fu+zheng+i]-1;
            }
            out = Math.min(out,res);
        }
        return out;
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] A = new int[len];
        for(int i=0;i<len;i++){
            A[i] = sc.nextInt();
        }
        int res = fun(A);
        System.out.println(res);

    }
}
