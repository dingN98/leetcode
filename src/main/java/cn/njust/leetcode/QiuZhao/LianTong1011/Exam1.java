package cn.njust.leetcode.QiuZhao.LianTong1011;



import java.util.ArrayList;
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        line = line.replace("head = [","");
        String[] twoArgs = line.split("], n = ");
//        System.out.println(twoArgs[0]);
//        System.out.println(twoArgs[1]);
        String[] numsStr = twoArgs[0].split(",");

        ArrayList<Integer> nodes = new ArrayList<>();
        for(String tmp:numsStr){
            nodes.add(Integer.parseInt(tmp));
        }
        int n = Integer.parseInt(twoArgs[1]);

        nodes.remove(nodes.size()-n);
        System.out.print("[");
        for(int i=0;i<nodes.size()-1;i++){
            System.out.print(nodes.get(i)+",");
        }
        System.out.print(nodes.get(nodes.size()-1));
        System.out.print("]");

//        System.out.println(nodes);
//        System.out.println(n);

    }
}
