package cn.njust.leetcode.JZOffer;

public class JZ65 {

    // 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
    public int Add(int num1,int num2) {
        // 使用 异或  模拟二进制对应位相加  但是会丢失进位
        // 与操作可以得到进位  然后将进位左移一位，交给高位
        while(num2!=0){
            int tmp1 = num1 ^ num2;
            int tmp2 = (num1 & num2)<<1;
            num1 = tmp1;
            num2 = tmp2;
        }
        return num1;
    }

    public static void main(String[] args) {

        int res = new JZ65().Add(1,2);
        System.out.println(res);

    }
}
