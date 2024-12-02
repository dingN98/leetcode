package cn.njust.leetcode.QiuZhao.XingHuan0903;

import java.util.HashMap;
import java.util.Scanner;

public class Exam1 {

    public static int fun(int[][] nums){
        int res = 0;
        int len = nums.length;
        HashMap<String,Integer> map = new HashMap<>();
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
                String key = nums[i][0]+","+nums[i][1];
                if(!map.containsKey(key)){
                    map.put(key,1);
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] nums = new int[len][2];
        for(int i=0;i<len;i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        int res = fun(nums);
        System.out.println(res);

    }
}
