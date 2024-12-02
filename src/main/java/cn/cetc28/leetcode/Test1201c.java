package cn.cetc28.leetcode;

import cn.njust.leetcode.NiuKe.栈和队列.SortUtil;

import java.util.Arrays;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/2 0:03
 * 004 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class Test1201c {

    public static void main(String[] args) {

        int[] a = new int[]{2,2,4,4};
        int[] b = new int[]{2,2,2,4};
        Test1201c t = new Test1201c();
        System.out.println(t.findMedianSortedArrays(a,b));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len3 = len1+len2;
        int[] nums3 = new int[len3];
        int i = 0;
        int j = 0;
        int k = 0;
        while(k<len1+len2){
            if(i<len1 && j<len2){
                if(nums1[i]<nums2[j]){
                    nums3[k++] = nums1[i++];
                }else{
                    nums3[k++] = nums2[j++];
                }
            }else if(i<len1){
                nums3[k++] = nums1[i++];
            }else{
                nums3[k++] = nums2[j++];
            }

        }
//        for(k=0;k<nums3.length;k++){
//            System.out.print(nums3[k]+",");
//        }
//        System.out.println();
        return (nums3[(len3-1)/2]+nums3[(len3)/2])/2.0;
    }
}
