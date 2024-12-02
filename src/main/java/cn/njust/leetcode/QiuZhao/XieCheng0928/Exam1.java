package cn.njust.leetcode.QiuZhao.XieCheng0928;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam1 {

    public static boolean fun(String A,String B){
        if(A.length()!=B.length()){
            return false;
        }
        if(A.equals(B)){
            for(int i=0;i<A.length();i++){
                if(A.indexOf(A.charAt(i),i+1)!=-1){
                    return true;
                }
            }
            return false;
        }else{
            List<Integer> differList = new ArrayList<>();
            for(int i=0;i<A.length();i++){
                if(A.charAt(i)!=B.charAt(i)){
                    differList.add(i);
                }
            }
            if(differList.size()!=2){
                return false;
            }
            boolean res1 = A.charAt(differList.get(0))==B.charAt(differList.get(1));
            boolean res2 = A.charAt(differList.get(1))==B.charAt(differList.get(0));
            if(res1 && res2){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int turns = sc.nextInt();
        for(int t=0;t<turns;t++){
            String A = sc.next();
            String B = sc.next();
            boolean res = fun(A,B);
            System.out.println(res==true?"Yes":"No");
        }
    }
}
