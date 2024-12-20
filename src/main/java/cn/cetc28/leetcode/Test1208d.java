package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/8 21:23
 * 033 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Test1208d {

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,8,1,2,3};
        Test1208d t = new Test1208d();
        int res = t.search(nums, 8);
        System.out.println(res);

    }

    public int search(int[] nums, int target) {

        int len = nums.length;
        int left = 0;
        int right = len-1;
        int mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[left]==target){
                return left;
            }
            if(nums[right]==target){
                return right;
            }
            if(nums[left]<nums[right]){
                // 序列终于恢复正常（升序）
                if(target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                // 一定有一半是递增的，就是常规的二分查找
                // 0 1 2 3 4 5 6 7  target==3
                // 5 6 7 0 1 2 3 4
                // 3 4 5 6 7 0 1 2
                //
                if(nums[left]<nums[mid]){
                    if(target>nums[left] && target<nums[mid]){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }else{
                    if(target>nums[mid] && target<nums[right]){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }
            }

        }
        return -1;
    }
}
