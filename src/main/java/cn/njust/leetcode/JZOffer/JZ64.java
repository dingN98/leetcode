package cn.njust.leetcode.JZOffer;

public class JZ64 {

    //  计算  1+2+3+。。。+n
    //  要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    public int Sum_Solution(int n) {
        //  思路   1+n=2+(n-1)  使用移位操作代替乘除
        //   使用位运算  &1    判断奇偶  flag=1表示n为奇数
        int flag = n&1;
        // 如果n是偶数
        int tmp = (n>>1)*(1+n);
        // 偶数下  flag=0  奇数下flag=1
        tmp += flag * (n+1)>>1;
        return tmp;
    }

    public static void main(String[] args) {

        int n = 5;
//        int n = 1;
        int res = new JZ64().Sum_Solution(n);
        System.out.println(res);
    }
}
