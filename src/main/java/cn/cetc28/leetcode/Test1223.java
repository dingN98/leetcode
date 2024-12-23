package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/23 19:42
 * 074 搜索二维矩阵
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class Test1223 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 二分法，查询在第几行
        int lines = matrix.length;
        int cols = matrix[0].length;
        int[] list = new int[lines*2];
        int idx = 0;
        for(int i=0;i<lines;i++){
            list[idx++] = matrix[i][0];
            list[idx++] = matrix[i][cols-1];
        }
        int left = 0;
        int right = list.length-1;
        int mid;
        int res = right;
        while(left<=right){
            mid = (left+right)/2;
            if(list[mid]==target){
                return true;
            }else if(target<list[mid]){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        // target<list[res]且res最小
        if(res%2==0){
            return false;
        }
        int line = res/2;
        left = 0;
        right = cols-1;
        while(left<=right){
            mid = left+(right-left)/2;
            if(matrix[line][mid]==target){
                return true;
            }else if(matrix[line][mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        Test1223 t = new Test1223();
        System.out.println(t.searchMatrix(matrix, target));


    }
}
