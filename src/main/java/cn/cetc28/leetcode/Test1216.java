package cn.cetc28.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/16 19:43
 * 054 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *  0 0,0
 *  1 0,1
 *  2 0,2
 *  3 0,3
 *  4 1,3
 *  5 2,3
 *  6 2,2
 *  7 2,1
 *  8 2,0
 *  9 1,0
 *  10 1,1
 *  11 1,2
 */
public class Test1216 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int line = matrix.length;
        int col = matrix[0].length;
        // 0代表向右，1代表向下，2代表向左，3代表向上
        int locationX = 0;
        int x = 0;
        int y = 0;
        for(int i=0;i<line*col;i++){
//            System.out.print(matrix[x][y]+",");
            res.add(matrix[x][y]);
            matrix[x][y] = 1000;
            if(locationX==0){
                if((y+1)==col || matrix[x][y+1]==1000){
                    locationX = 1;
                    x++;
                }else{
                    y++;
                }

            }else if(locationX==1){
                if((x+1)==line || matrix[x+1][y]==1000){
                    locationX = 2;
                    y--;
                }else{
                    x++;
                }
            }else if(locationX==2){
                if((y-1)==-1 || matrix[x][y-1]==1000){
                    locationX = 3;
                    x--;
                }else{
                    y--;
                }
            }else{
                if((x-1)==-1 || matrix[x-1][y]==1000){
                    locationX = 0;
                    y++;
                }else{
                    x--;
                }
            }

//            if(x>=0 && x<line && y>=0 && y<col){
//                if(matrix[x][y]!=1000){
//
//                }else{
//                    locationX = (locationX+1)%4;
//                }
//            }

        }
        return res;

    }

    public static void main(String[] args) {

        Test1216 t = new Test1216();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(t.spiralOrder(matrix));

    }
}
