package cn.njust.leetcode.DP.小游戏嘛;


public class Lee174_2 {
    public int calculateMinimumHP(int[][] dungeon) {

        // 寻找最大路径（权重之和最大）
        int rows = dungeon.length;
        int cols = dungeon[0].length;

        int MAX_VAL = Integer.MAX_VALUE;

        int[][] dp = new int[rows][cols];
        // dp[i][j] 表示到达（i.j) 之前 的生命至少为多少 (到达之后的生命至少为1）



        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=0;j--){
                if(i==rows-1 && j==cols-1){
                    // 终点
                    dp[rows-1][cols-1] = dungeon[rows-1][cols-1]>=0?1:(1-dungeon[rows-1][cols-1]);
                }else if(i==rows-1){
                    //最后一行(去除终点）
                    dp[i][j] = Math.max(dp[i][j+1]-dungeon[i][j],1);
                }else if(j==cols-1){
                    // 最后一列
                    dp[i][j] = Math.max(dp[i+1][j]-dungeon[i][j],1);
                }else{
                    dp[i][j] = Math.max(1,Math.min(dp[i][j+1]-dungeon[i][j],dp[i+1][j]-dungeon[i][j]));
                }
            }
        }

//        for(int i=0;i<rows;i++){
//            for(int j=0;j<cols;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        return dp[0][0];

    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int res = new Lee174_2().calculateMinimumHP(dungeon);
        System.out.println(res);
    }

}
