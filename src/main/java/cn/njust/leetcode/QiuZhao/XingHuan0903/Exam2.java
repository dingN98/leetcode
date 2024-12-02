package cn.njust.leetcode.QiuZhao.XingHuan0903;

import java.util.*;

public class Exam2 {

    public static int fun(int[][] matrix){
        int len = matrix.length;
        ArrayList<int[]> rise = new ArrayList<>();
        ArrayList<int[]> down = new ArrayList<>();
        for(int i=0;i<len;i++){
            int[] tmp = new int[2];
            tmp[0] = matrix[i][0];
            tmp[1] = matrix[i][1];
            if(matrix[i][0]<matrix[i][1]){
                rise.add(tmp);
            }else{
                down.add(tmp);
            }
        }
        if(rise.size()>0){
            Collections.sort(rise, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
        }
        if(down.size()>0){
            Collections.sort(down, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
        }
        int res = 0;
        for(int i=0;i<rise.size();i++){
            res += rise.get(i)[1] - rise.get(i)[0];
            if(i<rise.size()-1){
                res+=Math.abs(rise.get(i+1)[0]-rise.get(i)[1]);
            }
        }
        if(rise.size()>0 && down.size()>0){
            res  += Math.abs(rise.get(rise.size()-1)[1]-down.get(0)[0]);
        }

        for(int i=0;i<down.size();i++){
            res += down.get(i)[0] - down.get(i)[1];
            if(i<down.size()-1){
                res+=Math.abs(down.get(i+1)[0]-down.get(i)[1]);
            }
        }
        res+=down.get(down.size()-1)[1]-1;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] nums = new int[len][2];
        for(int i=0;i<len;i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        int res = fun(nums);
        System.out.println(res);
    }




}
