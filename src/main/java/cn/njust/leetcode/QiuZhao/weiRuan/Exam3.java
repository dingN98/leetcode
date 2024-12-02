package cn.njust.leetcode.QiuZhao.weiRuan;

public class Exam3 {

    int minCost = Integer.MAX_VALUE;

    int solution(int A[], int N, int X, int Y) {
        // write your code in C (C99 (gcc 6.2.0))
        search(A,X,Y,0,-Y,0);
        return minCost;
    }

    public void search(int[] nums,int maxCnt,int Y,int cnt,int idx,int cost){
        if(cnt==maxCnt){
            minCost = Math.min(minCost,cost);
            return;
        }
        for(int i=idx+Y;i<nums.length;i++){
            search(nums,maxCnt,Y,1+cnt,i,cost+nums[i]);
        }
    }

    public static void main(String[] args) {
//        int[] A = {4,2,3,7};
//        int[] A = {10,3,4,7};
        int[] A = {4,2,5,4,3,5,1,4,2,7};
        int res = new Exam3().solution(A,A.length,3,2);
        System.out.println(res);

    }
}
