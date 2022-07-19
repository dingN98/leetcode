package cn.njust.leetcode.JZOffer;

public class JZ15 {

    public int NumberOf1(int n) {

        // 将n减去1  再和  n  按位与  就会把 n 最后一位1变成 0

        int cnt = 0;
        while(n!=0){
            n = n & (n-1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
//        int n = 10;
        int n = -1;
        int res = new JZ15().NumberOf1(n);
        System.out.println(res);
    }
}
