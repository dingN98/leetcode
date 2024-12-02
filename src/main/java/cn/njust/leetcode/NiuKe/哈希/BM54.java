package cn.njust.leetcode.NiuKe.哈希;

import java.util.*;
public class BM54 {

    // 三数之和
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        HashSet<String> set = new HashSet<>();
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<len;i++){
            ArrayList<ArrayList<Integer>> tmp = twoSum(nums,i);
            for(ArrayList<Integer> tmp2:tmp){
                StringBuilder key = new StringBuilder();
                for(Integer tmp3:tmp2){
                    key.append(tmp3).append(",");
                }
                String key2 = key.toString();
                if(!set.contains(key2)){
                    set.add(key2);
                    res.add(tmp2);
                }
            }
//            res.addAll(tmp);
        }
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

    public ArrayList<ArrayList<Integer>> twoSum (int[] numbers, int idx) {
        // write code here
        int target = -numbers[idx];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // 余数  下标
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=idx+1;i<numbers.length;i++){
            int num = numbers[i];
            if(map.containsKey(target-num)){
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(numbers[idx]);
                tmp.add(numbers[map.get(target-num)]);
                tmp.add(numbers[i]);
                res.add(tmp);
            }else{
                map.put(num,i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
//        int[] nums = {-40,-10,-10,0,10,20};
        ArrayList<ArrayList<Integer>> res = new BM54().threeSum(nums);
        System.out.println(res);
    }
}
