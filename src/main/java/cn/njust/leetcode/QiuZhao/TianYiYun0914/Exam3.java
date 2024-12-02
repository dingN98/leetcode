package cn.njust.leetcode.QiuZhao.TianYiYun0914;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Exam3 {

    static class obj {
        public int key;
        public double val;

        public obj(int key, double val) {
            this.key = key;
            this.val = val;
        }
    }

    public static int[] str2array(String str){
        System.out.println("解析 "+str);
        String[] tmp = str.split(" ");
        int[] res = new int[tmp.length];
        for(int i=0;i<tmp.length;i++){
            res[i] = Integer.parseInt(tmp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int len1 = sc.nextInt();
        int[] value = new int[len1];
        for(int i=0;i<len1;i++){
            value[i] = sc.nextInt();
        }
        int len2 = sc.nextInt();
        int[] cost = new int[len2];
        for(int i=0;i<len1;i++){
            cost[i] = sc.nextInt();
        }
        ArrayList<obj> A = new ArrayList<>();
        for(int i=0;i<value.length;i++){
            A.add(new obj(i,(double)value[i]/(double)cost[i]));
        }
        Collections.sort(A, new Comparator<obj>() {
            @Override
            public int compare(obj o1, obj o2) {
                double tmp = o2.val-o1.val;
                if(tmp==0.0){
                    return 0;
                }else if(tmp>0){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        int res = 0;
        for(int i=0;i<A.size();i++){
            int idx = A.get(i).key;
            if(total>=cost[idx]){
                res += value[idx];
                total -= cost[idx];
            }
        }
        System.out.println(res);






    }
}
