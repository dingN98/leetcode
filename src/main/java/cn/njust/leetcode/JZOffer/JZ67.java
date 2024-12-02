package cn.njust.leetcode.JZOffer;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;

public class JZ67 {

    // 把字符串转换成整数(atoi)
    // 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。传入的字符串可能有以下部分组成:
    //1.若干空格
    //2.（可选）一个符号字符（'+' 或 '-'）
    //3. 数字，字母，符号，空格组成的字符串表达式
    //4. 若干空格

    public int StrToInt (String s) {
        int len = s.length();
        if(len==0){
            return 0;
        }
        // write code here
        // 首先删除空格
        int idx = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)!=' '){
                idx = i;
                break;
            }
        }
        // 正负号
        int flag = 1;
        if(s.charAt(idx)=='+'){
            idx++;
        }else if(s.charAt(idx)=='-'){
            flag = -1;
            idx++;
        }
        if(idx>=len){
            return 0;
        }
        // 数字、字母、符号、空格
        if(!Character.isDigit(s.charAt(idx))){
            return 0;
        }
        StringBuilder digitBuilder = new StringBuilder();
        // 去掉数字开头的0  例如   000123
        int zeroFlag = 0;
        int zeroFlag2 = 0;
        for(int i=idx;i<len;i++){
            char ch = s.charAt(i);
            if(ch!='0'){
                zeroFlag = 1;
            }
            if(ch=='0' && zeroFlag==0){
                zeroFlag2 = 1;
                continue;
            }
            if(Character.isDigit(ch)){
                digitBuilder.append(ch);
            }else{
                break;
            }
        }
        String res = digitBuilder.toString();
        if(res.equals("") && zeroFlag2==1){
            res = "0";
        }
        String MAX = Integer.MAX_VALUE+"";
        String MIN = Integer.MIN_VALUE+"";
        if(flag==1){
            if(res.length()>MAX.length() || res.length()==MAX.length() && res.compareTo(MAX)>0){
                return Integer.MAX_VALUE;
            }else{
                return Integer.parseInt(res);
            }
        }else{
            res = "-"+res;
            if(res.length()>MIN.length() || res.length()==MIN.length() && res.compareTo(MIN)>0){
                return Integer.MIN_VALUE;
            }else{
                return Integer.parseInt(res);
            }
        }
//        return 0;
    }

    public static void main(String[] args) {
//        String s = "   -12  ";
//        String s = "4396 clearlove";
//        String s = "clearlove 4396";
//        String s = "-987654321111";
        String s = " 000000012345678";
        int res = new JZ67().StrToInt(s);
        System.out.println(res);
    }

}
