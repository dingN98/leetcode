package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/8 13:06
 *
 * 031 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 */
public class Test1208b {

    public static void main(String[] args) {

        int[] nums = {1,3,2};
        Test1208b t = new Test1208b();
        t.nextPermutation(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+",");
        }

    }

    // 5,3,1,4,2

    //         0 1 2 3 4 5 6
    // nums = [4,2,0,2,3,2,0]

    // 1,3,2
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = -1;
        for(int i=len-1;i>0;i--){
            // 从后向前找到一个升序序列
            if(nums[i-1]<nums[i]){
                index = i-1;
                break;
            }
        }
        // [index+1,len-1]之间的这段一定是降序或者平序
        // 找一个最小的（从后往前找第一个大于nums[index]的数
        // 并和nums[index]交换位置
        if(index!=-1){
            for(int i=len-1;i>0;i--){
                if(nums[i]>nums[index]){
                    int tmp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = tmp;
                    break;
                }
            }
        }

        // nums[index]后面的数字由小到大重新排序
        for(int i=index+1;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(nums[i]>nums[j]){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

    }
}
