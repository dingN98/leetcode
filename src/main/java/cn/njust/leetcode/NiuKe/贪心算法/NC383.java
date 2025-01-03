package cn.njust.leetcode.NiuKe.贪心算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NC383 {

    // NC383 主持人调度（一）  简单
    // 有 n 个活动即将举办，每个活动都有开始时间与活动的结束时间，第 i 个活动的开始时间是 starti ,第 i 个活动的结束时间是 endi ,举办某个活动就需要为该活动准备一个活动主持人。
    //一位活动主持人在同一时间只能参与一个活动。并且活动主持人需要全程参与活动，换句话说，一个主持人参与了第 i 个活动，那么该主持人在 (starti,endi) 这个时间段不能参与其他任何活动。请问一个只有一个主持人能否举办全部活动。

    public boolean hostschedule (ArrayList<ArrayList<Integer>> schedule) {
        // write code here
        Collections.sort(schedule, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0).equals(o2.get(0))){
                    return o1.get(1)-o2.get(1);
                }
                return o1.get(0)-o2.get(0);
            }
        });

        for(int i=0;i<schedule.size()-1;i++){
            if(schedule.get(i).get(1)>schedule.get(i+1).get(0)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
