package cn.njust.leetcode.QiuZhao.wangYi0820;

import java.util.Scanner;

public class Exam1 {


    public int getCnt(int[] nums){
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            int tmp = 0;
            int val1 = nums[i];
            int val2 = nums[i+1];
            if(val1==val2){
                continue;
            }
            int flag = 0;
            for(int j=0;j<nums.length && flag==0;j++){
                if((Math.abs(i-j))%2==1){
                    if(nums[j]>val2){
                        flag = 1;
                        break;
                    }
                    tmp += Math.abs(val2-nums[j]);
                }else{
                    if(nums[j]>val1){
                        flag = 1;
                        break;
                    }
                    tmp += Math.abs(val1-nums[j]);
                }
            }
            if(flag==0){
//                System.out.println(val1+" "+val2+" "+tmp);
                res = Math.min(res,tmp);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i] = scanner.nextInt();
        }
        int res = new Exam1().getCnt(nums);
        System.out.println(res);
    }
}
