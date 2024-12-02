package cn.njust.leetcode.QiuZhao.MicroSoft0825;

public class Exam3 {

    int res = 0;

    public int getSum(int n){
        return (1+n-3+1)*(n-2)/2;

    }

    public int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        int n = A.length;
        if(n<=2){
            return -1;
        }
        for(int i=0;i<n-2;i++){
            if(2*A[i+1] == A[i]+A[i+2]){
                int d = A[i+1]-A[i];
                int j = i+2;
                while(j<n && A[j]-A[j-1]==d){
                    j++;
                }
//                System.out.println("["+i+","+j+"]");
                res += getSum(j-i);
                i = j-2;
            }
        }
        return res;

//        int len = A.length;
//        int left = 0;
//        int right = 0;
//        for(int i=0;i<len;i++){
//            int cha1 = A[right]-A[left];
//            int cha2 = A[i]-A[right];
//            if(cha1==cha2){
//                right = i;
//            }else{
//                left = right = i;
//            }
//            if()
//        }
//        return 0;

    }

    public static void main(String[] args) {
//        int n = 10000;
//        int[] A = new int[10000];
        int[] A = {-1,1,3,3,3,2,3,2,1,0};
        int res = new Exam3().solution(A);
        System.out.println(res);


    }
}
