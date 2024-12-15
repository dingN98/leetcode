package cn.cetc28.leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.logging.log4j.util.PropertySource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/14 16:10
 * 040 组合总和II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 *
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class Test1214b {

    public static void main(String[] args) {

        Test1214b t = new Test1214b();
        int[] candidates = {1,1,1,1,1,1,1,1,1,2};
        int target = 3;
        System.out.println(t.combinationSum2(candidates, target));

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        HashMap<Integer,Boolean> visited = new HashMap<>();
        // 用map统计每种数字出现的次数，目的是去重
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<candidates.length;i++){
            if(map.containsKey(candidates[i])){
                map.put(candidates[i],map.get(candidates[i])+1);
            }else{
                map.put(candidates[i],1);
                visited.put(candidates[i],false);
            }
        }
//        System.out.println(map);
//        System.out.println(visited);


        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        fun(map,visited,target,path,res);
        return res;

    }

    public void fun(HashMap<Integer,Integer> map, HashMap<Integer, Boolean> visited, int target, List<Integer> path, List<List<Integer>> res){
        for (Integer candidate : map.keySet()) {
            if(visited.get(candidate)){
                continue;
            }
            visited.put(candidate,true);
            int count = map.get(candidate);
            for(int i=1;i<=count;i++){
                int num = candidate*i;
                if(num==target){
                    for(int j=0;j<i;j++){
                        path.add(candidate);
                    }
                    List<Integer> tmp = new ArrayList<>(path);
                    tmp.sort((o1,o2)->o1-o2);
                    if(!res.contains(tmp)){
                        res.add(tmp);
                    }
                    for(int j=0;j<i;j++){
                        path.remove(path.size()-1);
                    }
                }else if(num<target){
                    for(int j=0;j<i;j++){
                        path.add(candidate);
                    }
                    fun(map,visited,target-num,path,res);
                    for(int j=0;j<i;j++){
                        path.remove(path.size()-1);
                    }

                }else{
                    break;
                }
            }
            visited.put(candidate,false);
        }
    }
}
