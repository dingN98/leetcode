package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/15 12:48
 * 048 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 找规律   // 0,0 <- 3,0
 *         // 3,0 <- 3,3
 *         // 3,3 <- 0,3
 *
 *
 *
 *         // 法1.创建新数组  matrix[i][j] <- matrix[len-j-1][i]
 *
 *         // 法2：（1）tmp = matrix[i][j]
 *         //      (2)matrix[i][j]  = matrix[len-1-j][i]
 *         //      (3)matrix[len-1-j][i] = matrix[len-1-i][len-1-j]
 *         //      (4)matrix[len-1-i][len-1-j] = matrix[j][len-1-i]
 *         //      (5)matrix[j][len-1-i] = tmp;
 *
 */
public class Test1215c {

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int deep = (len+1)/2;
        int edge = len;
        for(int i=0;i<deep;i++){
            int edge2=edge==1?1:edge-1;
            for(int j=i;j<i+edge2;j++){
                int tmp = matrix[i][j];
                matrix[i][j]  = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
                matrix[j][len-1-i] = tmp;
            }
            edge -= 2;
            // 3*3 ，边长3,1     循环2,1
            // 4*4 ,边长4,2      循环3,1
            // 5*5 ，边长5，3,1   循环4,2,1
            // 6*6, 边长6，4，2   循环5,3,1
        }
    }

    public void rotate2(int[][] matrix) {
        int len = matrix.length;
        for(int i=0;i<len/2;i++){
            for(int j=0;j<(1+len)/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j]  = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
                matrix[j][len-1-i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        Test1215c t = new Test1215c();
        t.rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }

    }
}
