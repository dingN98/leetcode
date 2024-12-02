package cn.njust.leetcode.JZOffer;

public class JZ83 {

    long mod = 998244353;

    public long cutRope (long number) {
        // write code here

        if(number==2){
            return 1;
        }
        if(number==3){
            return 2;
        }
        long cnt = number/3;
        long yuShu = number%3;
        if(yuShu==0){
            // 全是3
            return pow(3,cnt);
        }else if(yuShu==1){
            // 拿一个1和3凑在一起
            return fast(4,pow(3,cnt-1));
        }else{
            // 余数为2
            return fast(2,pow(3,cnt));
        }

    }

    private long fast(long x, long y){
        long res = 0;
        x %= mod;
        y %= mod;
        while(y != 0){
            if((y & 1L) != 0){
                //加法代替乘法，防止越界
                res += x;
                if(res >= mod)
                    res -= mod;
            }
            y = y >> 1;
            x = x << 1;
            if(x >= mod)
                x -= mod;
        }
        return res;
    }
    //快速幂
    long pow(long x, long y){
        long res = 1;
        while(y != 0){
            //可以再往上乘一个
            if((y & 1L) != 0)
                res = fast(res, x);
            //叠加
            x = fast(x, x);
            //减少乘次数
            y = y >> 1;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
