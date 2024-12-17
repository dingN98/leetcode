package cn.cetc28.leetcode;

import com.sun.xml.internal.messaging.saaj.util.TeeInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/17 19:12
 * 057 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，
 * 其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，
 * 并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 *
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，
 * 且区间之间不重叠（如果有必要的话，可以合并区间）。
 *
 * 返回插入之后的 intervals。
 *
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Test1217 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int idx = search(intervals,newInterval[0],0);
        int idx2 = search(intervals,newInterval[1],1);
        System.out.println(idx+",,,,"+idx2);
        int len = intervals.length;
        List<int[]> res = new ArrayList<>();
        if(idx2<0){
            res.add(newInterval);
            res.addAll(Arrays.asList(intervals));
        }else if(idx>=len){
            res.addAll(Arrays.asList(intervals));
            res.add(newInterval);
        }else{
            int flag = 0;
            for(int i=0;i<len;i++){
                if(i<idx || i>idx2){
                    if(flag==1){
                        res.add(newInterval);
                        flag=2;
                    }
                    res.add(new int[]{intervals[i][0],intervals[i][1]});
                }else{
                    flag = 1;
                    newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                    newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
                }
            }
            if(flag!=2){
                res.add(newInterval);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }


    // 找出最逼近但是不等于的区间的下标，这个范围内的数组需要参加合并
    public int search(int[][] intervals,int target,int idx){
        int len = intervals.length;
        int left = 0;
        int right = len-1;
        int mid=0;
        int res = 0;
        while(left<=right){
            mid = (left+right)/2;
            if(target==intervals[mid][0] || target==intervals[mid][1]){
                return mid;
            }else if(idx==0){
                if(target>intervals[mid][1]){
                    res = mid+1;
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{
                if(target<intervals[mid][0]){
                    res = mid-1;
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Test1217 t = new Test1217();
        int[][] intervals = {{1,5},{9,100}};
        int[] newInterval = {7,8};
        int[][] res = t.insert(intervals, newInterval);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+","+res[i][1]);
        }

    }
}
