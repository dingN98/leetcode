package cn.njust.leetcode.QiuZhao.KeDaXunFei0917;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Exam3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<HashMap<String,Integer>> fc = new ArrayList<>();
        int[] sumList = new int[count];

        int maxSum = 0;

        sc.nextLine();
        for(int i=0;i<count;i++){
            String str = sc.nextLine();
//            System.out.println(str);
            String[] tmp = str.split(" ");
            fc.add(new HashMap<>());
            for(int j=0;j<tmp.length;j+=2){
                if(j==tmp.length-1){
                    sumList[i] = Integer.parseInt(tmp[j]);
                    maxSum = Math.max(maxSum,sumList[i]);
                    continue;
                }
                String key = tmp[j];
                if(!map.containsKey(key)){
                    map.put(key,-1);
                }
                fc.get(i).put(key,Integer.parseInt(tmp[j+1]));
            }

        }

        // 解方程
        System.out.println(map);
        System.out.println(fc);


    }
}
