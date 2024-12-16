package cn.cetc28.leetcode;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/16 21:04
 * 056 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Test1216b {

    public int[][] merge(int[][] intervals) {

        List<Pair> list = new ArrayList<>();
        for (int[] interval : intervals) {
            Pair p = new Pair(interval[0], interval[1]);
            list.add(p);
        }
        list.sort((o1, o2) -> o1.x-o2.x);

        for(int i=0;i<list.size()-1;i++){
            int x1 = list.get(i).x;
            int y1 = list.get(i).y;
            int x2 = list.get(i+1).x;
            int y2 = list.get(i+1).y;
            if(x1==x2){
                list.get(i).x = -1;
                list.get(i+1).y = Math.max(y1,y2);
            }else{
                if(y1>=x2){
                    list.get(i+1).x = Math.min(x1,x2);
                    list.get(i+1).y = Math.max(y1,y2);
                    list.get(i).x = -1;
                }
            }
        }

        List<Pair> list2 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            int x1 = list.get(i).x;
            int y1 = list.get(i).y;
            if(x1!=-1){
                Pair p = new Pair(x1,y1);
                list2.add(p);
            }
        }
        int[][] res = new int[list2.size()][2];
        for(int i=0;i<res.length;i++){
            res[i][0] = list2.get(i).x;
            res[i][1] = list2.get(i).y;
        }
        return res;
    }

    class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

    }
}
