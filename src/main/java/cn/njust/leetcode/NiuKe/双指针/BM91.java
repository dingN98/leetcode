package cn.njust.leetcode.NiuKe.双指针;

public class BM91 {


    // BM91 反转字符串
    // 入门
    // 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
    //
    //数据范围： 0 \le n \le 10000≤n≤1000
    //要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)

    public String solve (String str) {
        // write code here
        StringBuilder str2 = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            str2.append(str.charAt(i));
        }
        return str2.toString();
    }

    public static void main(String[] args) {

        String str = "abc";
        String res = new BM91().solve(str);
        System.out.println(res);

    }
}
