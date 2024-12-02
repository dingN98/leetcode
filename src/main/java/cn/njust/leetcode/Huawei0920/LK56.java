package cn.njust.leetcode.Huawei0920;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LK56 {

    // 合并区间
    public int[][] merge(int[][] intervals) {

        int len = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        ArrayList<int[]> res = new ArrayList<>();

        for(int i=0;i<len-1;i++){
            // 将相邻俩区间合并到后者
            if(intervals[i][1]>=intervals[i+1][0]){
                intervals[i+1][1] = Math.max(intervals[i][1],intervals[i+1][1]);
                intervals[i+1][0] = intervals[i][0];
            }else{
                res.add(intervals[i]);
            }
        }
        res.add(intervals[len-1]);

        int len2 = res.size();
        int[][] res2 = new int[len2][2];
        for(int i=0;i<len2;i++){
            res2[i] = res.get(i);
        }
        return res2;

    }

    public static void main(String[] args) {

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new LK56().merge(intervals);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }


    }
}
