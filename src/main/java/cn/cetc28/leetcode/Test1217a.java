package cn.cetc28.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/17 22:02
 *  * 057 插入区间
 *  * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，
 *  * 其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，
 *  * 并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 *  *
 *  * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，
 *  * 且区间之间不重叠（如果有必要的话，可以合并区间）。
 *  *
 *  * 返回插入之后的 intervals。
 *  *
 *  * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 *  *
 *  *
 *  *
 *  * 示例 1：
 *  *
 *  * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 *  * 输出：[[1,5],[6,9]]
 *  * 示例 2：
 *  *
 *  * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 *  * 输出：[[1,2],[3,10],[12,16]]
 *  * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Test1217a {

    public int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> res = new ArrayList<>();
        int len = intervals.length;
        boolean addFlag = false;
        for(int i=0;i<len;i++){
            if(newInterval[0]>intervals[i][1]|| newInterval[1]<intervals[i][0]){
                if(!addFlag && newInterval[1]<intervals[i][0]){
                    res.add(newInterval);
                    addFlag  = true;
                }
                res.add(intervals[i]);
            }else{
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
        }
        if(!addFlag){
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][2]);

    }
}
