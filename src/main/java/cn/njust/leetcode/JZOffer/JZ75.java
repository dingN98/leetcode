package cn.njust.leetcode.JZOffer;

import java.util.HashMap;
import java.util.HashSet;

public class JZ75 {

    // 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g" 。当从该字符流中读出前六个字符 “google" 时，第一个只出现一次的字符是"l"。

    HashMap<Character,Integer> map = new HashMap<>();

    StringBuilder stringBuilder = new StringBuilder();


    //Insert one char from stringstream
    public void Insert(char ch) {

        stringBuilder.append(ch);
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else{
            map.put(ch,1);
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {

        String str = stringBuilder.toString();
        char[] chList = str.toCharArray();
        for(int i=0;i<chList.length;i++){
            if(map.get(chList[i])==1){
                return chList[i];
            }
        }
        return '#';
    }

    public static void main(String[] args) {

    }
}
