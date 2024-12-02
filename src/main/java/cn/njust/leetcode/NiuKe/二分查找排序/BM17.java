package cn.njust.leetcode.NiuKe.二分查找排序;

public class BM17 {

    public int search (int[] nums, int target) {
        // write code here
        int res = binSearch(nums,0, nums.length-1,target);
        return res;
    }

    public int binSearch(int[] nums,int left,int right,int target){
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midV = nums[mid];
        if(target==midV){
            return mid;
        }
        int res = -1;
        if(target<midV){
            res = binSearch(nums,left,mid-1,target);
        }else{
            res = binSearch(nums,mid+1,right,target);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,4,6,10,13,14};
        int target = 13;
        int res = new BM17().search(nums,target);
        System.out.println(res);



    }
}
