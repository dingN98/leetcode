package cn.njust.leetcode.QiuZhao.XingHuan0903;

import java.util.HashMap;
import java.util.Scanner;

public class Exam1_2 {

    public static int fun(int[][] nums,int len2){
        int res = 0;
        int len = len2;
//        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            int flag = 0;

            for(int j=0;j<len;j++){
                if(i==j){
                    continue;
                }
                if(nums[j][0]<nums[i][0] && nums[j][1]>=nums[i][1] || nums[j][1]>nums[i][1] && nums[j][0]<=nums[i][0]){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                res++;
//                String key = nums[i][0]+","+nums[i][1];
//                if(!map.containsKey(key)){
//                    map.put(key,1);
//                    res++;
//                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] nums = new int[len][2];
        int len2 = 0;
        for(int i=0;i<len;i++){
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();
            String key = tmp1+","+tmp2;
            if(!map.containsKey(key)){
                map.put(key,1);
                nums[len2][0] = tmp1;
                nums[len2][1] = tmp2;
                len2++;
            }
        }
        int res = fun(nums,len2);
        System.out.println(res);

    }
}
