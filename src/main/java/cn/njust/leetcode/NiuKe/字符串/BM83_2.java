package cn.njust.leetcode.NiuKe.字符串;

import java.util.Locale;

public class BM83_2 {

    // 字符串变形  简单
    public String trans(String s, int n) {
        // write code here

        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
       for(int i=s.length()-1;i>=0;i--){
           char ch = s.charAt(i);
           if(ch==' '){
               if(tmp.toString().length()>0){
                   res.append(tmp.toString());
                   tmp = new StringBuilder();
               }
               res.append(ch);
               continue;
           }
           if(ch>='a' && ch<='z'){
               tmp.insert(0,(ch+"").toUpperCase());
           }else{
               tmp.insert(0,(ch+"").toLowerCase());
           }
        }
        if(tmp.toString().length()>0){
            res.append(tmp.toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        String s = "This is a sample";
        String s = "This is a sample ";
        String res = new BM83_2().trans(s,s.length());
        System.out.println(res);
    }

}
