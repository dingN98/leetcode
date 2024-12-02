package cn.njust.leetcode.QiuZhao.MicroSoft0825;

public class Exam2 {

    int ans = 0;

    public int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        int len = A.length;
        for(int i=0;i<len;i++){
            int sum = 0;
            for(int j=i;j<len;j++){
                sum += A[j];
                if(sum==0){
                    ans++;
                    if(ans>1000000000){
                        return -1;
                    }
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2,-2,3,0,4,-7};
        int res = new Exam2().solution(A);
        System.out.println(res);

    }
}
