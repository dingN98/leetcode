package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/24 23:02
 * 080 删除有序数组的重复项II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 */
public class Test1224 {

    public int removeDuplicates(int[] nums) {

        int last = nums.length;
        int cnt = 1;
        for(int i=1;i<last;i++){
            if(nums[i]==nums[i-1]){
                cnt++;
            }else{
                cnt = 1;
            }
            if(cnt>2){
                cnt = 0;
                for(int j=i;j<last;j++){
                    nums[j-1] = nums[j];
                }
                last--;
            }
        }
        return last;
    }

    public static void main(String[] args) {

    }
}
