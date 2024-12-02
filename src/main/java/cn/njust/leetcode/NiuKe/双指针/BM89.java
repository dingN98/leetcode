package cn.njust.leetcode.NiuKe.双指针;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BM89 {

    // BM89 合并区间   中等
    // 给出一组区间，请合并所有重叠的区间。
    //请保证合并后的区间按区间起点升序排列。
    //
    //数据范围：区间组数 0 \le n \le 2 \times 10^50≤n≤2×10
    //5
    // ，区间内 的值都满足 0 \le val \le 2 \times 10^50≤val≤2×10
    //5
    //
    //要求：空间复杂度 O(n)O(n)，时间复杂度 O(nlogn)O(nlogn)
    //进阶：空间复杂度 O(val)O(val)，时间复杂度O(val)O(val)


    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        if(intervals.size()<=1){
            return intervals;
        }

        // 排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {

                if(o1.start==o2.start){
                    return o1.end-o2.end;
                }
                return o1.start-o2.start;
            }
        });

        ArrayList<Interval> res = new ArrayList<>();

        // 前一个区间的end 大于等于  后一个区间的start  合并这俩区间   将值覆盖后一个区间
        for(int i=0;i<intervals.size();i++){
            Interval interval1 = intervals.get(i);
            Interval interval2 = intervals.get(i+1);
            if(interval1.end>= interval2.start){
                interval2.start = interval1.start;
                interval2.end = Math.max(interval1.end, interval2.end);
            }else{
                // 加入结果集合
                res.add(interval1);
            }

            if((i+1)==intervals.size()-1){
                res.add(interval2);
                break;
            }
        }

        return res;


    }

    public static void main(String[] args) {

        ArrayList<Interval> a = new ArrayList<>();
        a.add(new Interval(10,30));
//        a.add(new Interval(20,60));
//        a.add(new Interval(80,100));
//        a.add(new Interval(150,180));
        ArrayList<Interval> res = new BM89().merge(a);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i).start+","+res.get(i).end);
        }
//        System.out.println(res);

    }
}
