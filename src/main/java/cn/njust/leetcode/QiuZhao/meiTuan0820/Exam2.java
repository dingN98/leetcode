package cn.njust.leetcode.QiuZhao.meiTuan0820;


import java.util.Scanner;

public class Exam2 {

    double ans = 0;

    public void search(int[] nums,int[] p,double score,int k,int idx,int cnt){
        if(cnt>=k || idx>=nums.length){
            ans = Math.max(ans,score);
//            System.out.println(ans);
            return;
        }
        double add = nums[idx]*(100-p[idx])/100.0;
        // 这道题复习
        search(nums,p,score+add,k,idx+1,cnt+1);
        // 不复习
        search(nums,p,score,k,idx+1,cnt);
    }

    public double solution(int[] nums,int[] p,int k,double score){
        search(nums,p,score,k,0,0);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[len];
        int[] p = new int[len];
        double score = 0;
        for(int i=0;i<len;i++){
            p[i] = scanner.nextInt();
        }
        for(int i=0;i<len;i++){
            nums[i] = scanner.nextInt();
            score+=nums[i]*p[i]/100.0;
        }
//        System.out.println(score);
        double res = new Exam2().solution(nums,p,k,score);
        System.out.println(res);

        /**
         * 2 1
         * 89 38
         * 445 754
         */


    }
}
