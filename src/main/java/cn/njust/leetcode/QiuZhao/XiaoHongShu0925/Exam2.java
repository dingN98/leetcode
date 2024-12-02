package cn.njust.leetcode.QiuZhao.XiaoHongShu0925;

import java.util.Scanner;

public class Exam2 {

    public static String fun(String str1,String str2){
        // str1删除部分字符之后 是否等于  str2
        String res = "no";

        int idx = 0;
        int len = str2.length();
        char[] chs = str1.toCharArray();
        for(int i=0;i<chs.length && idx<len;i++){
            char ch = chs[i];
            char ch2 = str2.charAt(idx);
            if(ch==ch2){
                idx++;
            }
        }
        if(idx==len){
            res = "yes";
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int turns = sc.nextInt();
        for(int i=0;i<turns;i++){
            String str1 = sc.next();
            String str2 = sc.next();
            String res = fun(str1,str2);
            System.out.println(res);
        }
    }
}
