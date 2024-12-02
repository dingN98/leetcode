package cn.njust.leetcode.QiuZhao.GunagLianDa0831;

import java.util.HashMap;
import java.util.Scanner;

public class Exam1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            B[i] = sc.nextInt();
        }
        int res = 0;
        int index = n-1;
        HashMap<Integer,Integer> dic = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            if(A[i]!=B[index] && !dic.containsKey(B[index])){
                res++;
                dic.put(A[i],1);
            }else{
                index--;
            }
        }
        res = Math.min(res,n-res);
        System.out.println(res);
    }
}
