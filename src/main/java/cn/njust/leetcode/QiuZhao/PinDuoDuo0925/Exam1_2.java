package cn.njust.leetcode.QiuZhao.PinDuoDuo0925;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam1_2 {

    int maxStreetNum = 0;
    int minFood = Integer.MAX_VALUE;

    public void dfs(ArrayList<Integer>[] map, int[] cats, boolean[] visited, int streetNow, int foodMax, int foodNow, int streetNum){

        if((foodMax-foodNow)<cats[streetNow]){
            if(maxStreetNum==0) minFood = 0;
            return;
        }
        foodNow += cats[streetNow];
        streetNum += 1;
        if(streetNum > maxStreetNum){
            maxStreetNum = streetNum;
            minFood = foodNow;
        }else if(streetNum == maxStreetNum){
            minFood = Math.min(minFood,foodNow);
        }
//        System.out.println("目前在街区 "+streetNow+"  foodNow="+foodNow);

        visited[streetNow] = true;
        for(int i=0;i<map[streetNow].size();i++){
            int next = map[streetNow].get(i);

            if(visited[next]){
                continue;
            }
//            System.out.println("map["+streetNow+"]直通 "+i );
            dfs(map,cats,visited,next,foodMax,foodNow,streetNum);
        }
        visited[streetNow] = false;
    }

    public void fun(ArrayList<Integer>[] map,int[] cats,int foodMax){
        dfs(map,cats,new boolean[cats.length],0,foodMax,0,0);
        System.out.println(maxStreetNum+" "+minFood);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        ArrayList<Integer>[] map = new ArrayList[len];
        for(int i=0;i<len;i++){
            map[i] = new ArrayList<>();
        }
        int maxFood = sc.nextInt();
        int[] cats = new int[len];
        for(int i=0;i<len;i++){
            cats[i] = sc.nextInt();
        }
        for(int i=0;i<len-1;i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            map[a].add(b);
            map[b].add(a);
        }
//        for(int i=0;i<len;i++){
//            System.out.println(map[i]);
//        }
        new Exam1_2().fun(map,cats,maxFood);
    }
}
