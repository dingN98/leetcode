package cn.njust.leetcode.QiuZhao.JingDong0827;

import java.util.Locale;
import java.util.Scanner;

public class Exam1 {

    public String fun(String str,int k){
        String str1 = str.substring(0,k).toUpperCase();
        String str2 = str.substring(k).toLowerCase();
        return str1+str2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int k = scanner.nextInt();
        String str = scanner.next();
        String res = new Exam1().fun(str,k);
        System.out.println(res);

    }
}
