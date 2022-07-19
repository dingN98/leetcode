package cn.njust.leetcode.JZOffer;

public class JZ17 {

    public int[] printNumbers (int n) {
        int maxNum = (int)Math.pow(10,n);
        int[] res = new int[maxNum-1];
        for(int i=0;i<maxNum-1;i++){
            res[i] = i+1;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 1;
        int[] res = new JZ17().printNumbers(n);
        for(int tmp:res){
            System.out.print(tmp+" ");
        }
    }
}
