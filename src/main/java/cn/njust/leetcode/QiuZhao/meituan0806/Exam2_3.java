package cn.njust.leetcode.QiuZhao.meituan0806;

import java.util.Scanner;

public class Exam2_3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int right = 0;
        int sumA=0,sumB=0,sumC=0;
        int len = scanner.nextInt();
        int[] digits = new int[len];
        for(int i=0;i<len;i++){
            digits[i] = scanner.nextInt();
        }
        for(int i=0;i<len;i++){
            if(digits[i]==0){
                sumC++;
            }else if(digits[i]==-1){
                sumA++;
            }else{
                sumB++;
            }
        }
        int count = 0;
        int MIN = sumA;
        while(right<len){
            if(digits[right]>0){
                count++;
            }else if(digits[right]<0){
                sumA--;
            }
            MIN = Math.min(MIN,count+sumA);
            right++;
        }

        System.out.println(MIN+sumC);

    }
}
