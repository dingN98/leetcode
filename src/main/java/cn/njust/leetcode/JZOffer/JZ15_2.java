package cn.njust.leetcode.JZOffer;

public class JZ15_2 {

    public int NumberOf1(int n) {

        return Integer.toBinaryString(n).replaceAll("0","").length();
    }

    public static void main(String[] args) {
//        int n = 10;
        int n = -1;
        int res = new JZ15_2().NumberOf1(n);
        System.out.println(res);
    }
}
