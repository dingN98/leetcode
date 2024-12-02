package cn.njust.leetcode.QiuZhao.ZhongXin0905;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Exam2 {
    static ArrayList<String> res = new ArrayList<>();
    public static void fun(int[] nums,int k,int idx, int cnt){
        int len = nums.length;
        if(cnt==k){
            // 计算时间
            StringBuilder hourStr = new StringBuilder();
            StringBuilder minStr = new StringBuilder();
            for(int i=0;i<nums.length;i++){
                if(i<4){
                    hourStr.append(nums[i]);
                }else{
                    minStr.append(nums[i]);
                }
            }
            int hour = Integer.parseInt(hourStr.toString(),2);
            int minute = Integer.parseInt(minStr.toString(),2);
            if(hour>=12 || minute>59){
                return;
            }
            String tmp = hour+":"+String.format("%02d", minute);
            res.add(tmp);
            return;
        }
        if(idx>=len){
            return;
        }
        fun(nums,k,idx+1,cnt);
        nums[idx] = 1;
        fun(nums,k,idx+1,cnt+1);
        nums[idx] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] nums = new int[10];
        fun(nums,k,0,0);
        System.out.println(res);
    }
}