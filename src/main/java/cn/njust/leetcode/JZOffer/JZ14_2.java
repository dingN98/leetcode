package cn.njust.leetcode.JZOffer;

public class JZ14_2 {
    public int cutRope (int n) {

        int cnt = 0;
        while(n>=3){
            n-=3;
            cnt++;
        }

        if(n==0){
            return (int)Math.pow(3,cnt);
        } else if(n==2){
            return 2*(int)Math.pow(3,cnt);
        } else{
            return 4*(int)Math.pow(3,cnt-1);
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int res = new JZ14_2().cutRope(n);
        System.out.println(res);
    }
}
