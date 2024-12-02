package cn.njust.leetcode.QiuZhao.GunagLianDa0831;

import java.util.Scanner;

public class Exam2 {

    static int res = 0;

    public static void search(int[] nums,int[][] asks,int idx){
        int len = nums.length;
        if(idx==len-1){
            if(isRight(nums,asks)){
                int tmp = 0;
                for(int i=0;i<len;i++){
                    tmp+=nums[i];
                }
                res = Math.max(res,tmp);
            }
            return;
        }
        // 不坐人
        search(nums,asks,idx+1);
        // 坐人
        nums[idx] = 1;
        search(nums,asks,idx+1);
        nums[idx] = 0;
    }

    public static boolean isRight(int[] nums,int[][] asks){
        for(int i=0;i<asks.length;i++){
            int left = asks[i][0];
            int right = asks[i][1];
            int sum = asks[i][2];
            int tmp = 0;
            for(int j=left;j<=right;j++){
                tmp += nums[j];
                if(tmp>sum){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        int len2 = sc.nextInt();
        int[][] asks = new int[len2][3];
        for(int i=0;i<len2;i++){
            asks[i][0] = sc.nextInt()-1;
            asks[i][1] = sc.nextInt()-1;
            asks[i][2] = sc.nextInt();
        }
        search(nums,asks,0);
        System.out.println(res);

    }
}
