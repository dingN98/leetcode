package cn.njust.leetcode.QiuZhao.meituan0806;

import java.util.Scanner;

public class Exam1_3 {

    public static int cal(int xNum,int yNum){
        if(xNum+yNum<3){
            return 0;
        }
        int min = Math.min(xNum,yNum);
        xNum-=min;
        yNum-=min;
        int xyMax = Math.max(xNum,yNum);
        if(xyMax>=min){
            return min;
        }else{
            int tmp = (min-xyMax);
            return xyMax+cal(xNum+tmp,yNum+tmp);
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int turns = scanner.nextInt();
        int[] res = new int[turns];
        for(int t=0;t<turns;t++){
            int xNum = scanner.nextInt();
            int yNum = scanner.nextInt();
            res[t] = cal(xNum,yNum);

        }

        for(int t=0;t<turns;t++){
            System.out.println(res[t]);
        }

    }
}
