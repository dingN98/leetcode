package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/18 19:19
 * 059 螺旋矩阵
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 */
public class Test1218a {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] location = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int x = 0;
        int y = 0;
        int loc = 0;
        for(int i=0;i<n*n;i++){
            matrix[x][y] = i+1;
            if(x+location[loc][0]>=n || x+location[loc][0]<0 ||
                    y+location[loc][1]>=n || y+location[loc][1]<0 ||
                    matrix[x+location[loc][0]][y+location[loc][1]]>0){
                loc = (loc+1)%4;
            }
            x = x+location[loc][0];
            y = y+location[loc][1];
        }
        return matrix;


    }
    public static void main(String[] args) {

        Test1218a t = new Test1218a();
        int[][] ints = t.generateMatrix(3);
        for(int i=0;i<ints.length;i++){
            for(int j=0;j<ints[i].length;j++){
                System.out.print(ints[i][j]+",");
            }
            System.out.println();
        }

    }
}
