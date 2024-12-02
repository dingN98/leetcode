package cn.njust.leetcode.QiuZhao.XinHuan1015;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Exam1 {

    // 找到一个数的因子
    public static ArrayList<Integer> getYZ(int num){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=num;i>=1;i--){
            if(num%i==0){
                res.add(i);
            }
        }
        return res;
    }

    public static void fun(char[][] matrix){
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        ArrayList<Integer> list1 = getYZ(len1);
        ArrayList<Integer> list2 = getYZ(len2);

        int ans1 = 0;
        int min1=0,min2=0;
        for(int num1:list1){
            for(int num2:list2){
                int size1 = len1/num1;
                int size2 = len2/num2;

                HashSet<String> set = new HashSet<>();
                int flag = 0;

                for(int i=0;i<size1 && flag==0;i++){
                    for(int j=0;j<size2;j++){
                        // 起始坐标
                        int x = i*num1;
                        int y = j*num2;
                        StringBuilder tmp = new StringBuilder();
                        for(int k=0;k<num1;k++){
                            for(int m=0;m<num2;m++){
                                tmp.append(matrix[x+k][y+m]);
                            }
                        }
                        String tmp2 = tmp.toString();
                        if(set.contains(tmp2) || set.contains(tmp.reverse().toString())){
                            flag = 1;
                            break;
                        }else{
                            set.add(tmp2);
                        }
                    }
                }
                if(flag==0){
                    ans1++;
                    min1 = num1;
                    min2 = num2;
                }
            }
        }
        System.out.println(ans1);
        System.out.println(min1+" "+min2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len1 = sc.nextInt();
        int len2 = sc.nextInt();

        char[][] matrix = new char[len1][len2];
        for(int i=0;i<len1;i++){
            matrix[i] = sc.next().toCharArray();
        }
        fun(matrix);
    }
}
