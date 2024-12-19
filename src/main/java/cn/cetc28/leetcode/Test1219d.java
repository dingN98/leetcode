package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/19 21:01
 * 066 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Test1219d {

    public int[] plusOne(int[] digits) {
        int yuShu = 0;
        int jinWei = 1;
        for(int i=digits.length-1;i>=0;i--){
            yuShu = digits[i]+jinWei;
            jinWei = yuShu/10;
            yuShu = yuShu%10;
            digits[i] = yuShu;
        }
        if(jinWei==0){
            return digits;
        }else{
            int[] res = new int[digits.length+1];
            res[0] = jinWei;
            for(int i=0;i<digits.length;i++){
                res[i+1] = digits[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
