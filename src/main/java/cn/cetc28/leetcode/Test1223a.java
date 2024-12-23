package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/23 20:20
 *  * 074 搜索二维矩阵
 *  * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *  *
 *  * 每行中的整数从左到右按非严格递增顺序排列。
 *  * 每行的第一个整数大于前一行的最后一个整数。
 *  * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class Test1223a {

    public boolean searchMatrix(int[][] matrix, int target){
        int lines = matrix.length;
        int cols = matrix[0].length;
        if(cols == 0 || target < matrix[0][0] || target > matrix[lines - 1][cols - 1]){
            return false;
        }
        int left = 0;
        int right = lines-1;
        int mid;
        int idx = right;
        while(left<=right){
            mid = (left+right)/2;
            if(target==matrix[mid][cols-1]){
                return true;
            }else if(target<matrix[mid][cols-1]){
                idx = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println("idx="+idx);
        left = 0;
        right = cols-1;
        while (left<=right){
            mid = (left+right)/2;
            if(target == matrix[idx][mid]){
                return true;
            }else if(target<matrix[idx][mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        Test1223a t = new Test1223a();
        System.out.println(t.searchMatrix(matrix, target));

    }
}
