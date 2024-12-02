package cn.njust.leetcode.QiuZhao.FengHuo0829;

import java.util.*;

public class Exam3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int pre,cur;
        for(int qq=0;qq<q;qq++){
            pre = sc.nextInt();
            cur = sc.nextInt();
            int sum = 0;
            for(int i=0,j=n-1;i<n && j>=0;i++,j--){
                if((A[j]*pre-B[i]*cur)<0){
                    break;
                }else{
                    sum += (A[j]*pre-B[i]*cur);
                }
            }
            System.out.println(sum);
        }
    }
}
