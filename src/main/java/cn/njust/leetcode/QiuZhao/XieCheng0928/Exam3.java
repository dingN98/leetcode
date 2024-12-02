package cn.njust.leetcode.QiuZhao.XieCheng0928;


import java.util.Arrays;
import java.util.Scanner;

public class Exam3 {

    public static double fun(int[] nums,int k){
        int len = nums.length;
        int k2 = k;
        if(k>=len){
            return 0;
        }
        Arrays.sort(nums);
        // 双指针  谁距离平均值远  谁优先被选中
        int sum = Arrays.stream(nums).sum();
        double average = sum/(double)len;
        int left = 0;
        int right = len-1;
        int sum2 = 0;
        int flag = 0;
        while(k2>0){
            if(flag==0){
                double tmp1 = Math.abs(nums[left]-average);
                double tmp2 = Math.abs(nums[right]-average);
                if(tmp1<tmp2){
                    sum2 += nums[right--];
                    flag = 1;
                }else{
                    sum2 += nums[left++];
                    flag = 2;
                }
            }else if(flag==1){
                sum2 += nums[left++];
                flag = 0;
            }else{
                sum2 += nums[right--];
                flag = 0;
            }
            k2--;
        }
        double average2 = sum2/(double)k;
        if(average2<nums[left]){
            return nums[right]-average2;
        }else if(average2>nums[right]){
            return average2-nums[left];
        }
        return nums[right]-nums[left];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i] = sc.nextInt();
        }
        double res = fun(nums,k);
        System.out.println(res);
    }
}
