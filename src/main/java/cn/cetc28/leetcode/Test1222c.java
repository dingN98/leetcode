package cn.cetc28.leetcode;

import org.apache.coyote.http11.filters.VoidOutputFilter;

import java.util.HashSet;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/22 21:16
 * 073 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 *
 */
public class Test1222c {

    public void setZeroes(int[][] matrix) {
        int lines = matrix.length;
        int cols = matrix[0].length;
        // 首先找到第一个出现的matrix[i][j]==0,那么第i行和第j列就被征用，用来存储所有的行，列哪里是0
        int x = -1;
        int y=-1;
        for(int i=0;i<lines && x==-1;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        if(x==-1){
            return;
        }
        for(int i=0;i<lines;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    matrix[x][j] = 0;
                    matrix[i][y] = 0;
                }
            }
        }
        for(int i=0;i<lines;i++){
            for(int j=0;j<cols;j++){
                if(i==x || j==y){
                    continue;
                }
                // 如果第i行或者第j列要为0
                if(matrix[i][y]==0 || matrix[x][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<lines;i++){
            matrix[i][y] = 0;
        }
        for(int j=0;j<cols;j++){
            matrix[x][j] = 0;
        }

//        HashSet<Integer> linesSet = new HashSet<>();
//        HashSet<Integer> colsSet = new HashSet<>();
//        for(int i=0;i<lines;i++){
//            for(int j=0;j<cols;j++){
//                if(matrix[i][j]==0){
//                    linesSet.add(i);
//                    colsSet.add(j);
//                }
//            }
//        }
//
//        for (Integer i : linesSet) {
//            for(int j=0;j<cols;j++){
//                matrix[i][j] = 0;
//            }
//        }
//        for(int i=0;i<lines;i++){
//            for (Integer j : colsSet) {
//                matrix[i][j] = 0;
//            }
//        }
    }



    public static void main(String[] args) {

    }
}
