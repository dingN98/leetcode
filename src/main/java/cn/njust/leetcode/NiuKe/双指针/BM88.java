package cn.njust.leetcode.NiuKe.双指针;

public class BM88 {

    public boolean judge (String str) {
        //  BM88 判断是否为回文字符串  入门
        // 给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
        // 字符串回文指该字符串正序与其逆序逐字符一致。
        if(str.length()<=1){
            return true;
        }
        int left = 0,right = str.length()-1;
        while(left<right){
            if(str.charAt(left)==str.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

//        String str = "abcba";
        String str = "abcbas";
        boolean res = new BM88().judge(str);
        System.out.println(res);

    }
}
