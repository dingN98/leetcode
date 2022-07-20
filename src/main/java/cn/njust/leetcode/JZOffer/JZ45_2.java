package cn.njust.leetcode.JZOffer;

import java.util.Arrays;
import java.util.Comparator;

public class JZ45_2 {

//    String minV = "MAX";

    public String PrintMinNumber(int [] numbers) {

        // 最初的想法是  dfs  但是会超时  只会通过  11/15 个用例
        // 然后看题解
        // 1、转换为 String 数组
        // 2、排序  排序规则  (s1+s2).compareTo(s2+s1)  解释 3 31   肯定是  313小于331
        // 3、拼接String数组作为输出

        int len = numbers.length;
        String[] nums = new String[len];

        for(int i=0;i< len;i++){
            nums[i] = numbers[i]+"";
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        StringBuilder res = new StringBuilder();
        for(String tmp:nums){
            res.append(tmp);
        }
        return res.toString();

    }

//    public void search(String[] nums,int k,String path,boolean[] visited){
//
//        if(k==nums.length){
//            // 比较大小
//            if(minV.equals("MAX")){
//                minV = path;
//                return;
//            }
//            if(path.length() < minV.length()){
//                minV = path;
//            }else if(path.length()==minV.length()){
//                minV = minV.compareTo(path)>0?path:minV;
//            }
//        }
//
//        for(int i=0;i<nums.length;i++){
//            if(!visited[i]){
//                visited[i] = true;
//                search(nums,k+1,path+nums[i],visited);
//                visited[i] = false;
//            }
//        }
//    }

    public static void main(String[] args) {
//        int[] numbers = {1,2,3};
        int[] numbers = {3,32,321};
//        int[] numbers = {};
        String res = new JZ45_2().PrintMinNumber(numbers);
        System.out.println(res);
    }
}
