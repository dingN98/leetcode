package cn.njust.leetcode.QiuZhao.AboveAll;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {

//        System.out.println("?");
//        String s1 = "hello",s2 = "word";
//        String s3 = s1+", ";
//        String s4 = "hello"+", ";
//        String s5 = s1+", "+"world";
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);
//        System.out.println(s5);
//        List<String> list1 = new ArrayList<>();
//        List<String> list2 = new ArrayList<>();
//        System.out.println(list1.getClass().equals(list2.getClass()));

        String a = "nowcoder";
        String b = "nowcoder";
        String c = new String("nowcoder");
        String d = "now"+"coder";
        String e = "now"+new String("coder");
        System.out.println(a==c);
        System.out.println(a==b);
        System.out.println(a==d);
        System.out.println(a==e);


    }
}
