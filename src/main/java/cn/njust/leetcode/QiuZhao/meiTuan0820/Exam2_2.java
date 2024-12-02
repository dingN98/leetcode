package cn.njust.leetcode.QiuZhao.meiTuan0820;


import java.util.Arrays;
import java.util.Scanner;

public class Exam2_2 {
    public double solution(int[] nums,int[] p,int k,double score){
        double[] add = new double[nums.length];
        double adds = 0;
        for(int i=0;i<nums.length;i++){
            add[i] = nums[i]*(100-p[i])/100.0;
        }
        Arrays.sort(add);
        for(int i=0;i<k && i<nums.length;i++){
            adds += add[nums.length-i-1];
        }
        return score+adds;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[len];
        int[] p = new int[len];
        double score = 0;
        for(int i=0;i<len;i++){
            p[i] = scanner.nextInt();
        }
        for(int i=0;i<len;i++){
            nums[i] = scanner.nextInt();
            score+=nums[i]*p[i]/100.0;
        }
//        System.out.println(score);
        double res = new Exam2_2().solution(nums,p,k,score);
        System.out.println(res);

        /**
         * 2 1
         * 89 38
         * 445 754
         */


    }
}
