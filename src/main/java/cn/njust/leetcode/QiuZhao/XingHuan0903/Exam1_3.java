package cn.njust.leetcode.QiuZhao.XingHuan0903;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Exam1_3 {

    public static int fun(int[][] nums){

        int len = nums.length;

        HashMap<String,Integer> map = new HashMap<>();


        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for(int i=0;i<len;i++){
            int flag = 0;
            for(int j=0;j<i;j++){
                if(nums[j][1]>=nums[i][1]){
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                String key = nums[i][0]+","+nums[i][1];
                if(!map.containsKey(key)){
                    map.put(key,1);
                }
            }
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        for(int i=0;i<len;i++){
            int flag = 0;
            for(int j=i+1;j<len;j++){
                if(nums[j][0]<=nums[i][0]){
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                String key = nums[i][0]+","+nums[i][1];
                if(!map.containsKey(key)){
                    map.put(key,1);
                }else{
                    map.put(key,2);
                }
            }
        }
        int res = 0;
        for(int tmp:map.values()){
            if(tmp==2){
                res++;
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
        int res = fun(Arrays.copyOf(nums,len2));
        System.out.println(res);

    }
}
