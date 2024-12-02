package cn.njust.leetcode.NiuKe.字符串;

import java.util.HashMap;

public class BM85 {

    // BM85 验证IP地址
    public String solve (String IP) {
        // write code here
        String res = "Neither";
        res = checkIpv4(IP)?"IPv4":res;
        res = checkIpv6(IP)?"IPv6":res;
        return res;
    }

    public boolean checkIpv4(String ip){
        String[] tmp = ip.split("\\.");
        int len = tmp.length;
        if(len!=4 || !checkStr(ip)){
            return false;
        }
        for(String tmp2:tmp){
            if(!isNumber(tmp2)){
                return false;
            }
            int num = Integer.parseInt(tmp2);
            if(num>255 || !tmp2.equals(num+"")){
                return false;
            }
        }
        return true;
    }

    public boolean checkIpv6(String ip){
        String[] tmp = ip.split(":");
        int len = tmp.length;
        if(len!=8 || !checkStr(ip)){
            return false;
        }
        for(String tmp2:tmp){
            if(tmp2.length()==0 || !is16(tmp2)){
                return false;
            }
            int num = Integer.parseInt(tmp2,16);
            if(num==0 && !tmp2.equals("0")){
                return false;
            }
        }
        return true;
    }

    // 检查是否是10进制
    public boolean isNumber(String str){
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='a' && ch<='z' || ch>='A'&&ch<='Z'){
                return false;
            }
        }
        return true;
    }
    // 检查是否是16进制
    public boolean is16(String str){
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='0' && ch<='9' || ch>='a' && ch<='f' || ch>='A'&&ch<='F'){

            }else{
                return false;
            }
        }
        return true;
    }
    // 检查:或.的个数
    public boolean checkStr(String str){
        int cnt1 = 0,cnt2 = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==':'){
                cnt1++;
            }
            if(ch=='.'){
                cnt2++;
            }
        }
        if(cnt1==7 || cnt2==3){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {

//        String ip = "172.16.254.1";
//        String ip = "172.16.254.01";
//        boolean res = new BM85().checkIpv4(ip);

//        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
//        String ip = "2001:0db8:85a3:0:0:8A2E:77:7334";
//        String ip = "1a1.4.5.6";
//        String ip = "256.256.256.256";
//        String ip = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";
        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        String res = new BM85().solve(ip);

        System.out.println(res);

    }
}
