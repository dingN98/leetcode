package cn.cetc28.leetcode;

import com.sun.org.apache.bcel.internal.generic.FRETURN;

import javax.smartcardio.ATR;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/9 23:23
 * 034 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class Test1209 {

    public static void main(String[] args) {

        int[] nums = {1,1,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4};
        int target = 3;
        Test1209 t = new Test1209();
        int[] ints = t.searchRange(nums, target);
        System.out.println("["+ints[0]+","+ints[1]+"]");

    }

    public int[] searchRange(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        fun(nums,target,0,nums.length-1,0,res);
        System.out.println(res);
        if(res.size()==0){
            return new int[]{-1,-1};
        }
        if(res.size()==1){
            return new int[]{res.get(0),res.get(0)};
        }
        res.sort(Comparator.comparingInt(o -> o));
        return new int[]{res.get(0),res.get(res.size()-1)};
    }

    /**
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @param location 0代表从等于target的那个nums[mid]往两边继续搜索，-1代表去左边搜索，1代表去右边搜索
     * @param res
     */
    public void fun(int[] nums,int target,int left,int right,int location,List<Integer> res){

        if(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                res.add(mid);
                if(location==0){
                    fun(nums,target,left,mid-1,-1,res);
                    fun(nums,target,mid+1,right,1,res);
                }else if(location==-1){
                    fun(nums,target,left,mid-1,-1,res);
                }else{
                    fun(nums,target,mid+1,right,1,res);
                }
            }else if(nums[mid]<target){
                fun(nums, target,mid+1,right,location,res);
            }else{
                fun(nums,target,left,mid-1,location,res);
            }
        }
    }


}
