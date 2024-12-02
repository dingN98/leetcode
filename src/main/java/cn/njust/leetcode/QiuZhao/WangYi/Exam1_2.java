package cn.njust.leetcode.QiuZhao.WangYi;

import java.util.ArrayList;

public class Exam1_2 {

    public ArrayList<ArrayList<Integer>> fun1(String line){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int idx = 0;
        line = line.replace(" ","").substring(1,line.length()-1);;
        String[] lines = line.split("]");
        for(String tmp:lines){
            tmp = tmp.replace("[","").replace(",[","");
            if(tmp.length()>0){
                res.add(new ArrayList<>());
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
//        String line = "[[1,2],[3,4,5]]";
//        String line = "[[1,2]]";
        String line = "[[1],[2]]";
        System.out.println(line);
        ArrayList<ArrayList<Integer>> res = new Exam1_2().fun1(line);
        System.out.println(res);
    }
}
