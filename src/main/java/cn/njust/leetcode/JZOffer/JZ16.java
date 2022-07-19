package cn.njust.leetcode.JZOffer;

public class JZ16 {

    public double Power(double base, int exponent) {

        if(exponent==0){
            return 1;
        }
        if(base==0){
            return 0;
        }

        int flag = exponent<0?-1:1;
        exponent = exponent<0?-exponent:exponent;
        double res = 1.0;
        while(exponent>0){
            res *= base;
            exponent--;
        }
        return flag==1?res:1.0/res;
    }

    public static void main(String[] args) {
        double base = 2.0;
        int exponent = -2;
        double res = new JZ16().Power(base,exponent);
        System.out.println(res);
    }
}
