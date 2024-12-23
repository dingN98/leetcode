package cn.cetc28.leetcode;

import javax.management.openmbean.InvalidOpenTypeException;
import java.util.HashMap;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/23 20:31
 * 075 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 */
public class Test1223b {

    public void sortColors(int[] nums) {

        int[] counts = new int[3];
        for (int num : nums) {
            counts[num]++;
        }
        int idx = 0;
        for(int i=0;i<counts[0];i++){
            nums[idx++] = 0;
        }
        for(int i=0;i<counts[1];i++){
            nums[idx++] = 1;
        }
        for(int i=0;i<counts[2];i++){
            nums[idx++] = 2;
        }

    }

    public static void main(String[] args) {

    }
}
