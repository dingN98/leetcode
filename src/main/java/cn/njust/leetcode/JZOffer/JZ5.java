package cn.njust.leetcode.JZOffer;

public class JZ5 {
    public String replaceSpace (String s) {
        // write code here
//        return s.replace(" ","%20");
        
        StringBuilder strBuilder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            strBuilder.append(ch==' '?"%20":ch);
        }
        return strBuilder.toString();

    }
}
