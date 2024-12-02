package cn.njust.leetcode.QiuZhao.SiKe0920;

import java.util.Scanner;

public class Exam1 {

    public String fun(int[] nums,int m){
        int len = nums.length;
        int cnt = 0;
        char flag = 'A';
        char[] res = new char[len];
        boolean[] visited = new boolean[len];
        while(cnt<len){
            int maxAbi = 0;
            int maxIdx = 0;
            // 找到最大能力者
            for(int i=0;i<len;i++){
                if(!visited[i]){
                    if(nums[i]>maxAbi){
                        maxAbi = nums[i];
                        maxIdx = i;
                    }
                }
            }
            // 挑人
            res[maxIdx] = flag;
            visited[maxIdx] = true;
            cnt++;
            int m2 = 0;
            for(int i=maxIdx-1;i>=0;i--){
                if(m2<m){
                    if(!visited[i]){
                        res[i] = flag;
                        m2++;
                        cnt++;
                        visited[i] = true;
                    }
                }else{
                    break;
                }
            }
            m2 = 0;
            for(int i=maxIdx+1;i<len;i++){
                if(m2<m){
                    if(!visited[i]){
                        res[i] = flag;
                        m2++;
                        cnt++;
                        visited[i] = true;
                    }
                }else{
                    break;
                }
            }
            flag = flag=='A'?'B':'A';
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(char tmp:res){
            stringBuilder.append(tmp);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i] = sc.nextInt();
        }
//        int[] nums = {3,6,1,7,2,5,4};
//        int m = 1;
        String res = new Exam1().fun(nums,m);
        System.out.println(res);

    }
}
