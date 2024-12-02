package cn.njust.leetcode.NiuKe.二分查找排序;

public class BM21 {

    // BM21 旋转数组的最小数字
    // 二分法

    public int minNumberInRotateArray(int [] array) {

        int left = 0;
        int right = array.length-1;
        while(left<right){
            // 去除相等的数
            while(left+1<right && array[left]==array[left+1]){
                left++;
            }
            int mid = (left+right)/2;
            if(array[mid]>array[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return array[left];

    }

    public static void main(String[] args) {

        int[] nums = {2,2,2,1,2};
//        int[] nums = {3,100,200,3};
//        int[] nums = {3,4,5,1,2};
        int res = new BM21().minNumberInRotateArray(nums);
        System.out.println(res);

    }
}
