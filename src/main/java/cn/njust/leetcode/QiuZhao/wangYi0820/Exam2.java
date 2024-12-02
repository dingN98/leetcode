package cn.njust.leetcode.QiuZhao.wangYi0820;

import java.util.Scanner;

public class Exam2 {

    int eCount = 0;
    int modifyCount = Integer.MAX_VALUE;
    public void search(char[] arr,int cnt,int idx){
        int len = arr.length;
        if(idx>=len){
            //todo  统计好e出现的次数
            String str = String.valueOf(arr);
            int count = 0;
            for(int i=0;i<=arr.length-3;i++){
                String tmp = str.substring(i,i+3);
                if(tmp.equals("red") || tmp.equals("der")){
                    count++;
                }
            }
            if(count==eCount){
                modifyCount = Math.min(modifyCount,cnt);
            }else if(count>eCount){
                eCount = count;
                modifyCount = cnt;
//                System.out.println("好e "+count+"   修改次数 "+cnt);
            }
            return;
        }
        // 不改
        search(arr,cnt,idx+1);
        // 改
        char ch = arr[idx];
        String str = "red";
        for(int i=0;i<str.length();i++){
            char ch2 = str.charAt(i);
            if(ch==ch2){
                continue;
            }
            arr[idx] = ch2;
            search(arr,cnt+1,idx+1);
            arr[idx] = ch;
        }
    }

    public int solution(String str){
        char[] arr = str.toCharArray();
        search(arr,0,0);
        return modifyCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int res = new Exam2().solution(str);
        System.out.println(res);
    }
}
