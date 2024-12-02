package cn.njust.leetcode.QiuZhao.XiaoHongShu0925;

import java.util.Arrays;
import java.util.Scanner;

public class Exam1 {

    public static int fun(int[] nums){
        Arrays.sort(nums);
        int number = 1;
        int lastNum = -1;
        for(int num:nums){
            if(lastNum==-1){
                lastNum = num;
//                System.out.println("第一次赋值");
            }else if(lastNum==num){
//                System.out.println("值重复");
                continue;
            }else{
//                System.out.println("值不同，修改赋值");
                lastNum = num;
            }
            if(num==number){
                number++;
            }else{
                break;
            }
        }

        return number-1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i] = sc.nextInt();
        }
        int res = fun(nums);
        System.out.println(res);

    }
}
