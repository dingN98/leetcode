package cn.njust.leetcode.JZOffer;

import java.util.ArrayList;
import java.util.List;

public class JZ29 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int upFloor = 0;
        int downFloor = rows-1;
        int leftFloor = 0;
        int rightFloor = cols-1;

        while(upFloor<=downFloor && leftFloor<=rightFloor){
            // 从左往右
            for(int i=leftFloor;i<=rightFloor;i++){
                res.add(matrix[upFloor][i]);
            }
            upFloor++;
            // 从上往下
            for(int i=upFloor;i<=downFloor;i++){
                res.add(matrix[i][rightFloor]);
            }
            rightFloor--;
            if(upFloor<=downFloor){
                // 从右往左
                for(int i=rightFloor;i>=leftFloor;i--){
                    res.add(matrix[downFloor][i]);
                }
                downFloor--;
            }
            if(leftFloor<=rightFloor){
                // 从下往上
                for(int i=downFloor;i>=upFloor;i--){
                    res.add(matrix[i][leftFloor]);
                }
                leftFloor++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1,2,3,4}};
//        int[][] matrix = {{1},{2},{3},{4}};
        ArrayList<Integer> res = new JZ29().printMatrix(matrix);
        System.out.println(res);
    }
}
