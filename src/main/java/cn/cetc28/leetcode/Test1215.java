package cn.cetc28.leetcode;

import java.awt.font.NumericShaper;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/15 9:54
 *  * 045 跳跃游戏II
 *  * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *  *
 *  * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *  *
 *  * 0 <= j <= nums[i]
 *  * i + j < n
 *  * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *  *
 *  *
 *  *
 *  * 示例 1:
 *  *
 *  * 输入: nums = [2,3,1,1,4]
 *  * 输出: 2
 *  * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *  *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *  * 示例 2:
 *  *
 *  * 输入: nums = [2,3,0,1,4]
 *  * 输出: 2
 */
public class Test1215 {

    public int jump(int[] nums){
        int len = nums.length;
        int[][] dp =new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i!=j){
                    dp[i][j] = len;
                }
            }
        }
        for(int i=0;i<len;i++){
            for(int j=1;j<=nums[i] && (i+j)<len;j++){
                dp[i][i+j] = 1;
            }
        }

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                for(int k=i+1;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
        return dp[0][len-1];

        // dp[i][j] = Math.min(dp[i][k]+dp[k][j])
    }

    public static void main(String[] args) {

        Test1215 t = new Test1215();
        int[] nums = {2,1};
        System.out.println(t.jump(nums));

    }
}
