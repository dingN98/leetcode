package cn.njust.leetcode.NiuKe.双指针;

public class BM87 {


    // BM87 合并两个有序的数组
    // 给出一个有序的整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组
    public void merge(int A[], int m, int B[], int n) {
        if(n==0){
            return;
        }
        if(m==0){
            int idx = n-1;
            while(idx>=0){
                A[idx] = B[idx];
                idx--;
            }
            return;
        }
        // A 和 B 都有元素
        // 记录合并后的数组最右边的下标
        int idx = m+n-1;
        int idxA = m-1;
        int idxB = n-1;

        while(idxB>=0 && idxA>=0){
            if(A[idxA] > B[idxB]){
                A[idx--] = A[idxA--];
            }else{
                A[idx--] = B[idxB--];
            }
        }
        merge(A,idxA+1,B,idxB+1);

    }

    public static void main(String[] args) {

    }
}
