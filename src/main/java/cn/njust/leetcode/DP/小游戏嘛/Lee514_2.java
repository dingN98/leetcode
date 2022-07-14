package cn.njust.leetcode.DP.小游戏嘛;

public class Lee514_2 {

    public int findRotateSteps(String ring, String key) {

        // 这题不是贪心
        // 不是当前最优 推出全局最优

        int len1 = ring.length();
        int len2 = key.length();
        int res = 0;
        int p1 = 0;
        int p2 = 0;
        while(p2<len2){

            char ch1 = ring.charAt(p1);
            char ch2 = key.charAt(p2);
            if(ch1==ch2){
                res++;
                p2++;
                continue;
            }
            p1 = (p1+1)%len1;
            res++;
        }

        // dp[i]  表示到达key的第 i 个字符需要的总次数
        int[] dp = new int[len2+1];



        return res;

    }

    //
    public int getLR(String ring,String key,int p1,int p2,int[] dp){
        int len1 = ring.length();
        int len2 = key.length();

        char ch1 = ring.charAt(p1);
        char ch2 = key.charAt(p2);

        // 向左或者向右需要转动指针的次数
        int res1 = 0;
        int res2 = 0;
        while (ch1!=ch2){
            p1 = (p1+1)%len1;
            res1++;

        }

        return 0;


    }

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        int res = new Lee514_2().findRotateSteps(ring,key);
        System.out.println(res);
    }

}
