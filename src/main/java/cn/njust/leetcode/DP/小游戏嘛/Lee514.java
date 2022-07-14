package cn.njust.leetcode.DP.小游戏嘛;

public class Lee514 {

    public int findRotateSteps(String ring, String key) {

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
        return res;

    }

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        int res = new Lee514().findRotateSteps(ring,key);
        System.out.println(res);
    }

}
