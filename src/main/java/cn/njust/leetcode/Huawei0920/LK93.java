package cn.njust.leetcode.Huawei0920;

import java.util.ArrayList;
import java.util.List;

public class LK93 {

    List<String> res = new ArrayList<>();

    // 93. 复原 IP 地址
    public List<String> restoreIpAddresses(String s) {
        dfs(s,"",0,0);
        return res;
    }

    public void dfs(String s,String path,int cnt,int idx){
        int len = s.length();
        if(cnt==4 && idx==len){
            res.add(path.substring(1));
            return;
        }
        if(idx==len || cnt==4){
            return;
        }
        // i代表数字字符串右边界
        for(int i=idx+1;i<=len;i++){
            String str = s.substring(idx,i);
            int number = isValid(str);
            if(number!=-1){
                dfs(s,path+"."+number,cnt+1,i);
            }
        }
    }

    // 判断数字是否有效
    public int isValid(String str){
        if(str.length()>3){
            return -1;
        }
        int number = Integer.parseInt(str);
        if(!str.equals(number+"") || number>255){
            return -1;
        }
        return number;
    }


    public static void main(String[] args) {
        String s = "101023";
//        String s = "0000";
//        String s = "25525511135";
        List<String> res = new LK93().restoreIpAddresses(s);
        System.out.println(res);

    }
}
