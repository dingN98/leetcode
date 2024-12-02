package cn.njust.leetcode.QiuZhao.ZiJie0828;

import java.util.*;

public class Exam1 {
    public ArrayList<Integer> canFinish(int numCourses, int[][] prerequisites,int[] nums) {
        Map<Integer, List<Integer>> hash = new HashMap<>();
        int[] canGet = new int[numCourses+1];
        for(int i=1;i<=numCourses;i++){
            canGet[i] = 1;
        }
        for (int[] map : prerequisites) {
            if (hash.containsKey(map[1])) hash.get(map[1]).add(map[0]);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(map[0]);
                hash.put(map[1], list);
            }
        }
        while (hash.size()>0) {
            List<Integer> del = new ArrayList<>();
            for (Integer target : hash.keySet()) {
                boolean head = false;
                for (Integer key : hash.keySet()) {
                    if (hash.get(key).contains(target)) {
                        head = true;
                        break;
                    }
                }
                if (!head) del.add(target);
            }
            if (del.size()==0){
                for(int key:hash.keySet()){
                    canGet[key] = 0;
                }
                break;
            }
            for (Integer target : del) hash.remove(target);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i:nums){
            res.add(canGet[i]);
        }
        return res;
    }

    public static int[] str2nums(String str){
        System.out.println("读取 "+str);
        String[] numsStr = str.split(" ");
        int[] nums = new int[numsStr.length];
        for(int i=0;i<numsStr.length;i++){
            String tmp = numsStr[i];
            nums[i] = Integer.parseInt(tmp);
        }
        return nums;
    }

    public static int[][] getPres(int[][] pres,int[][] pres2){
        int n1 = pres==null?0: pres.length;
        int n2 = pres2.length;
        int[][] presAll = new int[n1+n2][2];
        int n = 0;
        for(int i=0;i<n1;i++){
            presAll[n++] = pres[i];
        }
        for(int i=0;i<n2;i++){
            presAll[n++] = pres2[i];
        }
        return presAll;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
//        sc.next();
        String numsStr = sc.nextLine();
        sc.next();
        int[] nums = str2nums(numsStr);
        int[][] presAll = null;

        for(int i=0;i<lines-1;i++){
            String numsStr2 = sc.nextLine();
            sc.next();
            int[] nums2 = str2nums(numsStr2);
            int start = nums2[0];
            int[][] pres = new int[nums2.length-1][2];
            for(int j=1;j<nums2.length;j++){
                pres[j-1][0] = start;
                pres[j-1][1] = nums2[j];
            }
            presAll = getPres(presAll,pres);
        }

//        int[][] prerequisites = {{1,2},{1,3},{1,4},{4,1}};
//        int[] nums = {1,2,3,4};
//        int[][] nums = {{1,2},{1,3}};
        ArrayList<Integer> res = new Exam1().canFinish(4,presAll,nums);
//        System.out.println(res);



    }
}
