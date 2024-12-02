package cn.njust.leetcode.QiuZhao.rongYao0820;

import java.util.Scanner;

public class Exam1 {

    public double solution(int N,int X,int Y){
        if(N>=X){
            return 5+Y/(double)X*5+solution(N-X+Y,X,Y);
        }
        return N/(double)X;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] tmp = input.split(",");
        int N = Integer.parseInt(tmp[0]);
        int X = Integer.parseInt(tmp[1]);
        int Y = Integer.parseInt(tmp[2]);
        double res = new Exam1().solution(N,X,Y);
        System.out.println((int)Math.ceil(res));
    }
}
