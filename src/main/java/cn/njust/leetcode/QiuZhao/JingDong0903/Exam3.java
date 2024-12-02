package cn.njust.leetcode.QiuZhao.JingDong0903;

import java.util.HashMap;
import java.util.Scanner;

public class Exam3 {

    static HashMap<String,Integer> map = new HashMap<>();
    static int ans = 0;

    public static int isValid(String str){
        char[] s = str.toCharArray();
        int count = 0;
        for(int i=0;i<s.length;i++){
            if(s[i]=='('){
                count++;
            }else if(s[i]==')'){
                count--;
            }
            if(count<0){
                return -1;
            }
        }
        if(count==0){
            return s.length;
        }else{
            return -1;
        }

    }

    public static void fun2(char[] str,int i,String res){
//        System.out.println(res);
        if(i==str.length){
            int tmp = 0;
            if(map.containsKey(res)){
                tmp = map.get(res);
                ans += tmp;
            }else{
                tmp = isValid(res);
                if(tmp!=-1){
                    map.put(res,tmp);
                    ans +=tmp;
                }
            }
        }else{
            fun2(str,i+1,res);
            fun2(str,i+1,res+str[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        fun2(str.toCharArray(),0,"");
//        System.out.println(map);
        System.out.println(ans);
    }
}
