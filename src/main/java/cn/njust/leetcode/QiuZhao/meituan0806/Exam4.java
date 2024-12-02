package cn.njust.leetcode.QiuZhao.meituan0806;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] digits = new int[n];
        for(int i=0;i<n;i++){
            digits[i] = scanner.nextInt();
        }
        int[] nums = new int[k];
        for(int i=0;i<n;i++){
            nums[digits[i]-1]++;
        }
        int[] A = new int[k];
        for(int i=0;i<k;i++){
            A[i] = (int)Math.ceil(nums[i]/2.0);
        }

        ArrayList<Integer> train = new ArrayList<>();
        ArrayList<Integer> test = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(A[digits[i]-1]>0){
                train.add(i+1);
                A[digits[i]-1]--;
            }else{
                test.add(i+1);
            }
        }
        for(int i=0;i<train.size()-1;i++){
            System.out.print(train.get(i)+" ");
        }
        System.out.println(train.get(train.size()-1));
        for(int i=0;i<test.size()-1;i++){
            System.out.print(test.get(i)+" ");
        }
        System.out.println(test.get(test.size()-1));


    }
}
