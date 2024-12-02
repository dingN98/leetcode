package cn.njust.leetcode.JZOffer;

public class JZ64_2 {

    //  计算  1+2+3+。。。+n
    //  要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    public int Sum_Solution(int n) {


//        if(n>1){
//            return n+Sum_Solution(n-1);
//        }else{
////            return 1;
//            return n;
//        }
        // 基本思想是  使用&&代替上面的 if
        boolean flag = (n>1)&&(n += Sum_Solution(n-1))>0;
        return n;
    }

    public static void main(String[] args) {

        int n = 5;
//        int n = 1;
        int res = new JZ64_2().Sum_Solution(n);
        System.out.println(res);
    }
}
