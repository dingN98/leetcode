package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/2 22:18
 * 007 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class Test1202a {

    public static void main(String[] args) {

        int x = 1534236469;
        Test1202a t = new Test1202a();
        int res = t.reverse(x);
        System.out.println(res);

    }

    // 时间复杂度  O(log(X))
    // 空间复杂度   O(1)
    public int reverse(int x) {

        // 2147483647
        // -2147483648
        int MAX = Integer.MAX_VALUE;

        int MAX2 = MAX/10;

        int y1 = 0;
        int y2 = 0;
        int res = 0;
        int fuHao = 1;
        if(x<0){
            fuHao = -1;
            x = Math.abs(x);
        }
        while(x>0){
            y1 = x/10;
            y2 = x%10;
            x = y1;
            if(res>MAX2){
                return 0;
            }else if(res==MAX2){
                if(fuHao==1){
                    if(y2>7){
                        return 0;
                    }
                }else{
                    if(y2>8){
                        return 0;
                    }
                }

            }

            res = res*10+y2;
        }
        return res*fuHao;

    }
}
