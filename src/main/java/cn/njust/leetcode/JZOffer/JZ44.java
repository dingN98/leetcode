package cn.njust.leetcode.JZOffer;

import java.util.Locale;

public class JZ44 {
    // 01234567891011121314...  求第 n (n=0,1,2,3,..) 位数

    // 总体思路是
    // 设第n位所在的数字是 num
    // 1、先求  num 是几位数
    // 2、再求  num 是哪个数
    // 3、最后  算是  num 的第几位

    // !!!  注意使用  Math,pow()  函数可能会出现越界的情况  所以结果需要定义位  long

    // 范围      数字位数    数字联位数
    //  0                   1                0  单独计算
    //  1-9       1        9*1
    //  10-99      2       90*2
    //  100-999    3       900*3
    //  1000-9999  4    9000*4
    //  ...

    public int findNthDigit (int n) {
        int target = n;

        // 首先确定 n 的范围
        if(n<=9){
            return n;
        }
        int cnt = 1;
        while(true){
            long tmp = 9*(long)Math.pow(10,cnt-1)*cnt;
            if(n>=tmp){
                n-=tmp;
                cnt++;
            }else{
                break;
            }
        }
        // 确定 属于哪个数字
        //  比如  此时  cnt=3  n=124  可以计算得到属于  第42个三位数  的第1位
        int k = n/cnt;
        int yuShu = n%cnt;

        long tmp = (long)Math.pow(10,cnt-1)+k-1;


        if(yuShu==0){
            // System.out.println(target+" 属于第 "+k+" 个"+cnt+"位数 ("+tmp+") 的最后一位");
            // tmp的最后一位
            return (int)(tmp-(tmp/10)*10);
        }
        tmp++;
        // System.out.println(target+" 属于第 "+(k+1)+" 个"+cnt+"位数 ("+tmp+") 的第 "+yuShu+" 位");
        String tmpStr = tmp+"";
        return Integer.parseInt(tmpStr.substring(yuShu-1,yuShu));
    }

    public static void main(String[] args) {
//        int n = 20;
        int n = 1000000000;
        int res = new JZ44().findNthDigit(n);
        System.out.println(res);
    }
}
