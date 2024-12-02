package cn.njust.leetcode.QiuZhao.TianYiYun0914;

import java.util.Scanner;

public class Exam2_2 {

    public static int[] reOrderArray (int[] array) {
        // write code here
        int len = array.length;
        int idx = 0;
        int flag = 0;

        for(int i=0;i<len;i++){
            int tmp = array[i];
            if(tmp%2==0){
                // 是奇数 需要和前面的第一个偶数交换位置
                swap(array,i,idx);
                // 偶数和偶数交换位置 确保顺序
                for(int j=idx+1;j<i;j++){
                    swap(array,i,j);
                }
                idx++;
            }else{
                if(flag==0){
                    idx = i;
                    flag = 1;
                }
            }
        }
        return array;
    }

    public static void swap(int[] nums,int i,int j){
        int len = nums.length;
        if(i==j || i<0 || j<0 || i>=len || j>=len){
            return;
        }
        int tmp1 = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp1;
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        String[] tmp = sc.next().split(",");
        for(int i=0;i<len;i++){
            nums[i] = Integer.parseInt(tmp[i]);
        }
        reOrderArray(nums);

        System.out.print(nums[0]);
        for(int i=1;i<len;i++){
            System.out.print(","+nums[i]);
        }
    }
}
