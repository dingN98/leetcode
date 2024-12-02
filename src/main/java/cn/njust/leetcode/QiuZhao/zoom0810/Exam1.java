package cn.njust.leetcode.QiuZhao.zoom0810;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam1 {

    int res = 1;

    public void search(ArrayList<Integer>[] map,String colors,int pathRes,int start,int end,boolean[] visited){
//        System.out.println(start+" -> "+end);
        if(start==end){
            res += Math.abs(pathRes);
            System.out.println("1到 "+end+" = "+Math.abs(pathRes));
            return;
        }
        for(int i=0;i<map[start].size();i++){
            int endTmp = map[start].get(i);
            if(!visited[endTmp]){
                visited[endTmp] = true;
                int val = colors.charAt(endTmp-1)=='R'?1:-1;
                search(map,colors,pathRes+val,endTmp,end,visited);
                visited[endTmp] = false;
            }
        }
    }

    public int getAns(){
        /**
         * 5
         * RBRBB
         * 2 5
         * 1 5
         * 4 1
         * 3 5
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String colors = scanner.next();
        ArrayList<Integer>[] map = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map[a].add(b);
            map[b].add(a);

        }
        for(int i=2;i<=n;i++){
            boolean[] visited = new boolean[n+1];
            visited[1] = true;
            search(map,colors,1,1,i,visited);
        }


//        for(int i=1;i<=n;i++){
//            System.out.println(map[i]);
//        }
//        System.out.println(colors);

        return res;

    }

    public static void main(String[] args) {
        int res = new Exam1().getAns();
        System.out.println(res);

    }
}
