package cn.njust.leetcode.QiuZhao.meituan0806;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int turns = scanner.nextInt();
        int[] res = new int[turns];
        for(int t=0;t<turns;t++){
            int xNum = scanner.nextInt();
            int yNum = scanner.nextInt();
            if(xNum+yNum<3){
                res[t] = 0;
                break;
            }
            int min = Math.min(xNum,yNum);
            xNum-=min;
            yNum-=min;
            int xyMax = Math.max(xNum,yNum);
            if(xyMax>=min){
                res[t] = min;
                break;
            }
            res[t] = xyMax+(min-xyMax)*2/3;
        }

        for(int t=0;t<turns;t++){
            System.out.println(res[t]);
        }

    }
}
