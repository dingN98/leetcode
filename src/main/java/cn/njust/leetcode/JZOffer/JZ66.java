package cn.njust.leetcode.JZOffer;

public class JZ66 {

    // 给定一个数组 A[0,1,...,n-1] ,请构建一个数组 B[0,1,...,n-1] ,其中 B 的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]（除 A[i] 以外的全部元素的的乘积）。
    // 程序中不能使用除法。（注意：规定 B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2]）
    //对于 A 长度为 1 的情况，B 无意义，故而无法构建，用例中不包括这种情况。

    public int[] multiply(int[] A) {
        // 前缀积和后缀积
        int len = A.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];

        int tmp = 1;
        for(int i=0;i<len;i++){
            tmp *= A[i];
            prefix[i] = tmp;
        }

        tmp = 1;
        for(int i=len-1;i>=0;i--){
            tmp *= A[i];
            suffix[i] = tmp;
        }

        int[] res = new int[len];

        for(int i=0;i<len;i++){
            int tmp1 = ((i-1)>=0)?prefix[i-1]:1;
            int tmp2 = ((i+1)<len)?suffix[i+1]:1;
            res[i] =  tmp1*tmp2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[] res = new JZ66().multiply(A);
        for(int tmp:res){
            System.out.print(tmp+" ");
        }

    }
}
