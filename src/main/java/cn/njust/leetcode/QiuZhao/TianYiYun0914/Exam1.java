package cn.njust.leetcode.QiuZhao.TianYiYun0914;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Exam1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] nums = new int[len][2];
        for(int i=0;i<len;i++){
            String[] tmp = sc.next().split(",");
            nums[i][0] = Integer.parseInt(tmp[0]);
            nums[i][1] = Integer.parseInt(tmp[1]);
//            System.out.println(nums[i][0]+" "+nums[i][1]);
        }
        // 排序
        int res = 0;
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int start = nums[0][0];
        int end = nums[0][1];

        for(int i=1;i<nums.length;i++){
            int[] value = nums[i];
            while(end>value[0]){
                end = Math.max(value[1], end);
                i++;
                if(i>=nums.length)break;
                value = nums[i];
            }
            res += (end-start);
            start = value[0];
            end = value[1];
            i--;
        }
        System.out.println(res);

    }
}
