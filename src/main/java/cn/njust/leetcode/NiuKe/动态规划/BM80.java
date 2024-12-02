package cn.njust.leetcode.NiuKe.动态规划;

public class BM80 {

    // BM80 买卖股票的最好时机(一)
    public int maxProfit (int[] prices) {
        // write code here

        int len = prices.length;
        // 局部最小值
        int minPrice = Integer.MAX_VALUE;
        int maxPro = 0;
        for(int i=0;i<len;i++){
            int tmp = prices[i];
            minPrice = Math.min(minPrice,tmp);
            maxPro = Math.max(maxPro,tmp-minPrice);
        }
        return maxPro;

    }
}
