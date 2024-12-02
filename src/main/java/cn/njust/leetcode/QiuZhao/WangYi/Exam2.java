package cn.njust.leetcode.QiuZhao.WangYi;

import java.util.Scanner;

public class Exam2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 0;
        for(int i=0;i<=n;i++){
            if((i+"").contains("25")){
                res++;
            }
        }
        System.out.println(res);

    }
}
