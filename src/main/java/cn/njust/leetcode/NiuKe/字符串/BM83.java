package cn.njust.leetcode.NiuKe.字符串;

public class BM83 {

    // 字符串变形  简单
    public String trans(String s, int n) {
        // write code here

        StringBuilder res = new StringBuilder();
        String[] tmp = s.split(" ");
        for(int i=tmp.length-1;i>=0;i--){
            String tmp2 = tmp[i];
            StringBuilder tmp3 = new StringBuilder();
            for(int j=0;j< tmp2.length();j++){
                char ch = tmp2.charAt(j);
                tmp3.append((ch>='a' && ch<='z')?(ch+"").toUpperCase():(ch+"").toLowerCase());
            }
            res.append(tmp3.toString());
            if(i>0){
                res.append(" ");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "This is a sample";
        String res = new BM83().trans(s,s.length());
        System.out.println(res);
    }

}
