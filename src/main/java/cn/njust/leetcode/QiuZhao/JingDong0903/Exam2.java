package cn.njust.leetcode.QiuZhao.JingDong0903;

import java.util.Scanner;

public class Exam2 {
    public static int fun(int num){
        if(num==1){ return 0; }
        if(num==2){ return 1; }
        int[] tmp = fun2(num);
        if(tmp[0]==1){
            return 1+fun(1)+fun(num-1);
        }else{
            return 1+fun(tmp[0])+fun(tmp[1]);
        }
    }
    public static int[] fun2(int num){
        int[] res = new int[2];
        for(int i=1;i<=num/2;i++){
            for(int j=1;j<=num;j++){
                if(num==i*j){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int len = sc.nextInt();
        for(int i=0;i<len;i++){
            int num = sc.nextInt();
            int tmp =  fun(num);
            res += tmp;
//            System.out.println(num+"分裂需要"+tmp+"次");
        }
        System.out.println(res);

    }
}
