package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/22 20:51
 * 072 编辑距离
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 */
public class Test1222b {

    public int minDistance(String word1, String word2) {

        // dp[i][j]代表从 w1[0:i] 到 w2[0:j] 的编辑距离
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp= new int[1+len1][1+len2];
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                if(i==0){
                    // 新增j个符号
                    dp[i][j] = j;
                }else if(j==0){
                    // 删除i个符号
                    dp[i][j] = i;
                }else{
                    if(word1.charAt(i-1)==word2.charAt(j-1)){
                        dp[i][j] = Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]);
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
                    }
                }
            }
        }
        return dp[len1][len2];

    }

    public static void main(String[] args) {

    }
}
