package cn.njust.leetcode.QiuZhao.TianYiYun0914;

import java.util.Scanner;
import java.util.function.IntUnaryOperator;

public class Exam2 {

    public static void nuo(int[] a,int j,int nu){
        int b = a[j];
        while(nu-->0){
            a[j] = a[j-1];
            j--;
        }
        a[j] = b;
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        String[] tmp = sc.next().split(",");
        for(int i=0;i<len;i++){
            nums[i] = Integer.parseInt(tmp[i]);
        }
        int i = len;
        int j = 0;
        int nu = 0;
        while(i!=j){
            if(nums[j]%2==1){
                nuo(nums,j,nu);
            }else{
                j++;
                nu++;
            }
        }
        System.out.print(nums[0]);
        for(i=1;i<len;i++){
            System.out.print(","+nums[i]);
        }



    }
}
