package cn.njust.leetcode.QiuZhao.WangYi;

import java.util.Scanner;

public class Exam3_yzl {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int res = 0;
//        for(int i=0;i<=n;i++){
//            if((i+"").contains("25")){
//                res++;
//            }
//        }
//        System.out.println(res);

        int[][] map = new int[20][20];
        int[][] food = new int[20][20];
        int[][] fire = new int[3][3];
        fire[0] = new int[]{0,19,1};
        fire[1] = new int[]{10,9,1};
        fire[2] = new int[]{4,13,5};
        map[6][15] = 1;

        int cnt = 0;

        while(true){
            cnt++;
            // 遍历火
            for(int i=0;i<fire.length;i++){
                int x = fire[i][0];
                int y = fire[i][1];
                int start = fire[i][2];

            }

        }


    }
}
