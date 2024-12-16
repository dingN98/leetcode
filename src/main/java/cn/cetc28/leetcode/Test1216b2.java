package cn.cetc28.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/16 21:34
 * 056 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
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
public class Test1216b2 {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals){
        int len = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<intervals.length-1;i++){
            int x1 = intervals[i][0];
            int y1 = intervals[i][1];
            int x2 = intervals[i+1][0];
            int y2 = intervals[i+1][1];
            if(y1>=x2){
                intervals[i+1][0] = Math.min(x1,x2);
                intervals[i+1][1] = Math.max(y1,y2);
            }else{
                list.add(new int[]{x1,y1});
            }
        }
        list.add(new int[]{intervals[len-1][0],intervals[len-1][1]});
        return list.toArray(new int[list.size()][]);
    }
}
