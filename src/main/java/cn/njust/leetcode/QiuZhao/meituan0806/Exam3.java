package cn.njust.leetcode.QiuZhao.meituan0806;

import java.util.HashMap;
import java.util.Scanner;

public class Exam3 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] up = new int[len];
        int[] down = new int[len];
        for(int i=0;i<len;i++){
            int tmp = scanner.nextInt();
            up[i] = tmp;
            if(map.containsKey(tmp)){
                map.put(tmp,map.get(tmp)+1);
            }else{
                map.put(tmp,1);
            }
        }
        for(int i=0;i<len;i++){
            int tmp = scanner.nextInt();
            down[i] = tmp;
            if(map.containsKey(tmp)){
                map.put(tmp,map.get(tmp)+1);
            }else{
                map.put(tmp,1);
            }
        }
        boolean res = false;
        for(Integer key:map.keySet()){
            if(map.get(key)>=len/2){
                res = true;
                break;
            }
        }
        System.out.println(res ?1:-1);

    }
}
