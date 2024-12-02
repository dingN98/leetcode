package cn.njust.leetcode.NiuKe.字符串;

public class BM83_3 {

    // 字符串变形  简单
    public String trans(String s, int n) {
        // write code here

        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
       for(int i=s.length()-1;i>=0;i--){
           char ch = s.charAt(i);
           if(ch==' '){
               if(tmp.length()>0){
                   res.append(tmp.reverse().toString());
                   tmp = new StringBuilder();
               }
               res.append(ch);
               continue;
           }
           if(ch>='a' && ch<='z'){
               tmp.append(Character.toUpperCase(ch));
           }else{
               tmp.append(Character.toLowerCase(ch));
           }
        }
        if(tmp.length()>0){
            res.append(tmp.reverse().toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        String s = "This is a sample";
        String s = "This is a sample ";
        String res = new BM83_3().trans(s,s.length());
        System.out.println(res);
    }

}
