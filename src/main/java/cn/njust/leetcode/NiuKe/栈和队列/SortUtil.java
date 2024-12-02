package cn.njust.leetcode.NiuKe.栈和队列;

import java.util.PriorityQueue;

public class SortUtil {

    public void quickSort(int[] nums,int left,int right){
//        System.out.println("left: "+left+" right "+right);
        if(left>right){
            return;
        }

        int left2 = left,right2 = right;
        int a = nums[left];
        while(left<right){
            while(left<right && nums[right]>=a){
                right--;
            }
            if(left<right && nums[right]<a){
                nums[left] = nums[right];
            }
            while(left<right && nums[left]<=a){
                left++;
            }
            if(left<right && nums[left]>a){
                nums[right] = nums[left];
            }
        }
        nums[left] = a;
        quickSort(nums,left2,left-1);
        quickSort(nums,left+1,right2);
    }

    public void quickSort2(int[] nums,int left,int right){
//        System.out.println("left: "+left+" right "+right);
        if(left>right){
            return;
        }

        int left2 = left,right2 = right;
        int a = nums[left];
        while(left<right){
            while(left<right && nums[right]>=a){
                right--;
            }
            while(left<right && nums[left]<=a){
                left++;
            }
            // 交换
            if(left<right){
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
            }

        }
        nums[left2] = nums[left];
        nums[left] = a;
        quickSort2(nums,left2,left-1);
        quickSort2(nums,left+1,right2);
    }

    public static void main(String[] args) {

        int[] nums = {2,3,5,1,4,8,6,7};
        new SortUtil().quickSort2(nums,0,nums.length-1);
        for(int tmp:nums){
            System.out.print(tmp+" ");
        }

    }
}
