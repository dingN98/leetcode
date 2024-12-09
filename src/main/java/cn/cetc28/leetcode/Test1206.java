package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/6 22:15
 * 026 删除有序数据的重复项
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 */
public class Test1206 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,3,3,3,4};
        Test1206 t = new Test1206();
        int k = t.removeDuplicates(nums);
        for(int i=0;i<k;i++){
            System.out.print(nums[i]);
        }

    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int index = 0;
        for(int i=1;i<len;){
            if(nums[i]==nums[index]){
                i++;
            }else{
                nums[index+1] = nums[i];
                index++;
                i++;
            }
        }
        return index+1;
    }
}
