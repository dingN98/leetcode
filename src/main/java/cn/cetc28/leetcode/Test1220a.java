package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/20 20:01
 * 070 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 */
public class Test1220a {

    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

//        int[] dp = new int[n+1];
//        dp[1] = 1;
//        dp[2] = 2;
        int a = 1;
        int b = 2;
        int c = 0;
        for(int i=3;i<=n;i++){
//            dp[i] = dp[i-1]+dp[i-2];
            c = a+b;
            a = b;
            b = c;
        }
//        return dp[n];
        return c;
//        return climbStairs(n-1)+climbStairs(n-2);


    }

    public static void main(String[] args) {

        Test1220a t = new Test1220a();
        System.out.println(t.climbStairs(4));

    }
}
