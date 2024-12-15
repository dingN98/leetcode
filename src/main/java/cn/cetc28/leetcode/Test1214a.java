package cn.cetc28.leetcode;

import com.sun.org.apache.xpath.internal.functions.FuncUnparsedEntityURI;

import javax.smartcardio.ATR;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/14 15:42
 * 039 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 */
public class Test1214a {

    public static void main(String[] args) {

        Test1214a t = new Test1214a();
        int[] candidates = {8,7,4,3};
        int target = 11;
        System.out.println(t.combinationSum(candidates, target));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        fun(candidates,target,res,path);
        return res;
    }

    public void fun(int[] candidates,int target,List<List<Integer>> res,List<Integer> path){
        for(int i=0;i<candidates.length;i++){
            if(candidates[i]==target){
                path.add(candidates[i]);
                List<Integer> tmp = new ArrayList<>(path);
                tmp.sort(Comparator.comparingInt(o -> o));
                if(!res.contains(tmp)){
                    res.add(tmp);
                }
                path.remove(path.size()-1);
//                return;
            }else if(candidates[i] < target){
                path.add(candidates[i]);
                fun(candidates,target-candidates[i],res,path);
                path.remove(path.size()-1);
            }
        }
    }
}
