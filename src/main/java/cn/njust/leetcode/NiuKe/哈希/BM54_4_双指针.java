package cn.njust.leetcode.NiuKe.哈希;

import java.util.*;

public class BM54_4_双指针 {

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
        int len = numbers.length;
        int target = -numbers[idx];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // 余数  下标
        int left = idx+1;
        int right = len-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum == target){
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(numbers[idx]);
                tmp.add(numbers[left]);
                tmp.add(numbers[right]);
                res.add(tmp);
                // 自动去重
                while((1+left)<right && numbers[left]==numbers[left++]){
                    left++;
                }
                while(left<(right-1) && numbers[right-1]==numbers[right]){
                    right--;
                }
                left++;
            }
            if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-2,0,1,1,2};
        int[] nums = {-40,-10,-10,0,10,20};
        ArrayList<ArrayList<Integer>> res = new BM54_4_双指针().threeSum(nums);
        System.out.println(res);
    }
}
