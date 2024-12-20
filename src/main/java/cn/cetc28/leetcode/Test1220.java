package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/20 19:27
 * 069 x的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class Test1220 {

    public int mySqrt(int x) {

        int left = 0;
        int right= x;
        int mid = 0;
        int res = 0;
        while(left<=right){
            mid = (left+right)/2;
            if((long)mid*mid<=x){
                res = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return res;

    }

    // 法2：牛顿迭代法
    public int myNewton(int x){
        if(x==0){
            return 0;
        }
        double x0 = x;
        double x1 = 0;
        while(true){
            x1 = (x0+x/x0)/2;
            if(Math.abs(x1-x0)<1e-7){
                return (int)x0;
            }else{
                x0 = x1;
            }
        }
    }

    public static void main(String[] args) {
        Test1220 t = new Test1220();
        System.out.println(t.mySqrt(4));
        System.out.println(t.myNewton(99));

    }
}
