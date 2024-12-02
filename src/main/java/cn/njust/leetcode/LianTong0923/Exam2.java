package cn.njust.leetcode.LianTong0923;

import java.util.HashSet;
import java.util.Scanner;

public class Exam2 {

    public static int getStrNum(String str){

        char[] chs = str.toCharArray();
        int d = 0;
        HashSet<Integer> res = new HashSet<>();
        for(int i=0;i<chs.length;i++){
            char ch =  chs[i];
            if(ch>='0' && ch<='9'){
                d = d*10+Integer.parseInt(ch+"");
            }else{
                res.add(d);
                d = 0;
            }
        }
        if(d!=0){
            res.add(d);
        }
        return res.size();
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        System.out.println(getStrNum(str));
    }

}
