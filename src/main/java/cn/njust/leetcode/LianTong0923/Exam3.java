package cn.njust.leetcode.LianTong0923;

import java.util.Scanner;

public class Exam3 {

    public static int compress(char[] chs){
        StringBuilder res = new StringBuilder();
        char lastChar = ' ';
        int cnt = 0;
        for(int i=0;i<chs.length;i++){
            char ch = chs[i];
            if(lastChar==' '){
                lastChar = ch;
                cnt = 1;
                res.append(lastChar);
                continue;
            }
            if(ch==lastChar){
                cnt++;
                continue;
            }
            if(cnt>1){
                res.append(cnt);
            }
            lastChar = ch;
            cnt = 1;
            res.append(lastChar);
        }
        if(cnt>1){
            res.append(cnt);
        }
        for(int i=0;i<res.length();i++){
            chs[i] = res.charAt(i);
        }

       return res.length();
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            String line = cin.next();
            char[] chars = line.toCharArray();
            int result = compress(chars);
            System.out.println(String.valueOf(chars,0,result));
        }
    }

}
