package cn.njust.leetcode.QiuZhao.QiAnXin0825;

import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        str = str.substring(1,str.length()-1);
        String[] strings = str.split(",");
        int len = strings.length;
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = Integer.parseInt(strings[i]);
        }
        int max = 0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                max = Math.max(max,(j-i)*(Math.min(arr[j],arr[i])));
            }
        }
        System.out.println(max);
    }
}
