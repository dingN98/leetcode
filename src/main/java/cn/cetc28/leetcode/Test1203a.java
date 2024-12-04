package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/3 21:09
 * 009 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数
 * 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Test1203a {

    public static void main(String[] args) {

        Test1203a t = new Test1203a();
        int x = -121;
        System.out.println(t.isPalindrome(x));

    }

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x==0){
            return true;
        }
        if(x==reverse(x)){
            return true;
        }else{
            return false;
        }
    }

    public int reverse(int x){
        int res = 0;
        while(x>0){
            int yuShu = x%10;
            res = res*10+yuShu;
            x = x/10;
        }
        return res;
    }
}
