package cn.njust.leetcode.QiuZhao.meituan0806;

import java.util.HashMap;
import java.util.Scanner;

public class Exam3_2 {
    public static Integer cal(int n){
        if(n%2==0){
            return n/2;
        }else{
            return n/2+1;
        }
    }
    public static void main(String[] args) {
        HashMap<Integer,Integer> mapA = new HashMap<>();
        HashMap<Integer,Integer> mapB = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] a = new int[len];
        int[] b = new int[len];
        for(int i=0;i<len;i++){
            int tmp = scanner.nextInt();
            a[i] = tmp;
        }
        for(int i=0;i<len;i++){
            int tmp = scanner.nextInt();
            b[i] = tmp;
        }
        for(int i=0;i<len;i++){
            if(mapA.containsKey(a[i])){
                mapA.put(a[i],mapA.get(a[i])+1);
            }else{
                mapA.put(a[i],1);
            }
        }
        for(int i=0;i<len;i++){
            if(a[i]==b[i]){
                continue;
            }
            if(mapB.containsKey(b[i])){
                mapB.put(b[i],mapB.get(b[i])+1);
            }else{
                mapB.put(b[i],1);
            }
        }
        int res = Integer.MAX_VALUE;
        for(Integer key:mapA.keySet()){
            if(mapA.get(key)>=cal(len)){
                res = 0;
                System.out.println(0);
                return;
            }else{
                if(mapB.containsKey(key)){
                    if(mapA.get(key)+mapB.get(key)>=cal(len)){
                        res = Math.min(res,cal(len)-mapA.get(key));
                    }
                }
            }
        }
        if(res==Integer.MAX_VALUE){
            res = -1;
        }
        System.out.println(res);

    }
}
