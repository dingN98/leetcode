package cn.njust.leetcode.QiuZhao.WangYi;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam1 {

    public ArrayList<ArrayList<Integer>> fun1(String line){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int idx = 0;
        line = line.replace(" ","").substring(1,line.length()-1);;
        String[] lines = line.split("]");
        for(String tmp:lines){
            tmp = tmp.replace("[","").replace(",[","");
            if(tmp.length()>0){
                res.add(new ArrayList<>());
//                System.out.println(tmp);
                String[] tmp2 = tmp.split(",");
                for(String tmp3:tmp2){
                    if(tmp3.length()>0){
                        res.get(idx).add(Integer.parseInt(tmp3));
                    }
                }
                idx++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
        // [[1,2],[3,4,5]]
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        list.add(new ArrayList<>());
//        list.add(new ArrayList<>());
//        list.get(0).add(1);
//        list.get(0).add(2);
//        list.get(1).add(3);
//        list.get(1).add(4);
//        list.get(1).add(5);
//        System.out.println(list);
//        String line = list.toString();
//        System.out.println(line);
//        String line = "[[1,2],[3,4,5]]";
//        String line = "[[1,2]]";
        String line = "[[1],[2]]";
        System.out.println(line);
        ArrayList<ArrayList<Integer>> res = new Exam1().fun1(line);
        System.out.println(res);
    }
}
