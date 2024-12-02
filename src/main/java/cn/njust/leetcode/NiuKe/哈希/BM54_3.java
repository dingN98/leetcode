package cn.njust.leetcode.NiuKe.哈希;

import java.util.*;

public class BM54_3 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    HashSet<String> set = new HashSet<>();

    // 三数之和
    // 方法2  dfs  会超时
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        // 这个排序不是必要的 只是题目里的答案都是排序的
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>(),0);
        // 排序
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0).equals(o2.get(0))){
                    if(o1.get(1).equals(o2.get(1))){
                        return o1.get(2)-o2.get(2);
                    }
                    return o1.get(1)-o2.get(1);
                }
                return o1.get(0)-o2.get(0);
            }
        });
        return res;
    }

    public void dfs(int[] nums,int idx,ArrayList<Integer> path,int target){
        int len = nums.length;
        int cnt = path.size();
        int sum = 0;
        StringBuilder keyBuilder = new StringBuilder();
        for(int v:path){
            keyBuilder.append(v).append(",");
            sum+=v;
        }
        String key = keyBuilder.toString();
        if(cnt==3 && sum==target && !set.contains(key)){
            res.add(new ArrayList<>(path));
            set.add(key);
            return;
        }
        if(idx>=len){
            return;
        }
        // 不要
        dfs(nums,idx+1,path,target);
        // 要
        int num = nums[idx];
        path.add(num);
        dfs(nums,idx+1,path,target);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
//        int[] nums = {-2,0,1,1,2};
        int[] nums = {-40,-10,-10,0,10,20};
        ArrayList<ArrayList<Integer>> res = new BM54_3().threeSum(nums);
        System.out.println(res);
    }
}
