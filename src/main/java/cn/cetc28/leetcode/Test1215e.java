package cn.cetc28.leetcode;

import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/15 17:55
 * 050 power(x,n)
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class Test1215e {

    public double myPow(double x, int n) {

        if(n==0){
            return 1;
        }else if(n>0){
            return fun(x,n);
        }
        return 1/fun(x,Math.abs(n));
    }

    public double fun(double x, int n){
        // 会超时，看题解，使用快速幂
//        if(n==0){
//            return 1;
//        }
//        return x*fun(x,n-1);

        // 例如计算x的77次方，可以令y=x的38次方，那么 x的77次方为y*y*x
        if(n==0){
            return 1;
        }
        double y = fun(x,n/2);
        return n%2==0?y*y:y*y*x;
    }

    public static void main(String[] args) {

        Test1215e t = new Test1215e();
        System.out.println(t.myPow(2, -3));

    }
}
