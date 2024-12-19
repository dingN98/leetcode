package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/19 20:20
 */
public class Test1219a {

    public int uniquePaths(int m, int n){

        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1 || j==1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m][n];


    }

    // 递归会超时
    public int uniquePaths2(int m, int n){

        if(m==1 || n==1){
            return 1;
        }
        return uniquePaths2(m-1,n)+uniquePaths(m,n-1);
    }

    public static void main(String[] args) {

        Test1219a t = new Test1219a();
        System.out.println(t.uniquePaths2(3, 7));

    }
}
