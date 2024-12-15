package cn.cetc28.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/14 17:30
 * 040 组合总和II  暴力
 * [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
 * 30
 * 超时    172 / 176 个通过的测试用例
 */
public class Test1214b2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        boolean[] visited = new boolean[candidates.length];
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        fun(candidates,target,visited,path,res);
        return res;

    }

    public void fun(int[] candidates, int target, boolean[] visited, List<Integer> path, List<List<Integer>> res){
        for(int i=0;i<candidates.length;i++){
            if(visited[i]){
                break;
            }
            if(candidates[i] == target){
                path.add(candidates[i]);
                visited[i] = true;
                List<Integer> tmp = new ArrayList<>(path);
                tmp.sort((o1,o2)->o1-o2);
                if(!res.contains(tmp)){
                    res.add(tmp);
                }
                path.remove(path.size()-1);
                visited[i] = false;
            }else if(candidates[i]<target){
                path.add(candidates[i]);
                visited[i] = true;
                fun(candidates,target-candidates[i],visited,path,res);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }

}
