package cn.njust.leetcode.QiuZhao.AboveAll;

public class Exam1 {
    
    static double fun(int cnt,double r1,double r2,double r3,double r4){
        if(cnt==1){
            return r1+r2+r4;
        }
        r4 = r1+r2+r4;
        r4 = (r3*r4)/(r3+r4);
        return fun(cnt-1,r1,r2,r3,r4);
    }

    public static void main(String[] args) {
        double r1 = 1,r2 = 1,r3 = 1;
        double res = fun(5,r1,r2,r3,r3);
        System.out.println(res);
    }
}
