package cn.njust.leetcode.QiuZhao.WangYi;

import java.util.Scanner;

public class Exam2_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 1;
        int len = (n+"").length()-2;
        // 在前面加数字
        int num1 = (int)Math.pow(10,len);
//        for(int i=1;i<(int)Math.pow(10,len+1);i++){
//            if(Integer.parseInt(i+"25")<=n){
//                res++;
//            }
//        }
        // 在后面加
        for(int i=0;i<(int)Math.pow(10,len+1);i++){
            if(Integer.parseInt("25"+i)<=n){
                res++;
            }
        }

        System.out.println(res);

    }
}
