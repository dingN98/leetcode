package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/8 9:52
 * 029 两数相除
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 *
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 */
public class Test1208 {

    public static void main(String[] args) {

        int dividend = 2147483647;
        int divisor = -1;
        Test1208 t = new Test1208();
        int res = t.divide(dividend, divisor);
        System.out.println(res);
//        System.out.println(Integer.MAX_VALUE);

    }

    public int divide(int dividend, int divisor) {

        if(divisor==1){
            return dividend;
        }
        if(divisor==-1){
            if(dividend==Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        int fuHao = 1;
        if(dividend>0 && divisor<0 || dividend<0 && divisor>0){
            fuHao = -1;
        }
        dividend = dividend>0?-dividend:dividend;
        divisor = divisor>0?-divisor:divisor;
        int res = 0;
        while(dividend<=divisor){
            dividend -= divisor;
            // 2147483647
            // -2147483648
            if(fuHao>0){
                res++;
            }else{
                res--;
            }

        }
        return res;

    }
}
