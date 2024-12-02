package cn.njust.leetcode.QiuZhao.RongYao0902;

public class Exam1 {

    public int reverseBits (int n) {
        // write code here
        int res = 0;
        for(int i=0;i<32;i++){
            res = res<<1;
            res += n&1;
            n = n>>1;
        }
        return res;
    }



    public static void main(String[] args) {

    }
}
