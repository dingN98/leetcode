package cn.njust.leetcode.QiuZhao.XieCheng0928;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Exam2 {

    public static long fun(long[] nums,long target){

        HashMap<Long,Integer> map = new HashMap<>(1000);
        map.put(0L,0);
        map.putIfAbsent(target,Integer.MAX_VALUE);
        for(long i=233;i<=target;i+=233){
            map.putIfAbsent(i,Integer.MAX_VALUE);
            for(long number:nums){
                long key = i-number;
                if(key>=0){
                    map.putIfAbsent(key,Integer.MAX_VALUE);
                    if(map.get(key)!=Integer.MAX_VALUE){
                        map.put(i,Math.min(map.get(i),map.get(key)+1));
                    }
                }
            }
        }
        return map.get(target)==Integer.MAX_VALUE?-1:map.get(target);

//        long[] dp = new long[(int)(target+1)];
//        Arrays.fill(dp,Integer.MAX_VALUE);
//        dp[0] = 0;
//        for(int i=1;i<=target;i++){
//            for(long number:nums){
//                if(i-number>=0 && dp[i-number]!=Integer.MAX_VALUE){
//                    dp[i] = Math.min(dp[i],dp[(int)(i-number)]+1);
//                }
//            }
//        }
//        return dp[(int)target]==Integer.MAX_VALUE?-1:dp[(int)target];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int turns = sc.nextInt();

        for(long t=0;t<turns;t++){
            long target = sc.nextLong();
            long tmp = target;
            int len = 0;
            while(tmp>0){
                tmp/=10;
                len++;
            }
            long[] nums = new long[len-2];
            nums[0] = 233;
            for(int i=1;i<nums.length;i++){
                nums[i] = nums[i-1]*10;
            }

            long res = fun(nums,target);
            System.out.println(res);
        }
    }
}
