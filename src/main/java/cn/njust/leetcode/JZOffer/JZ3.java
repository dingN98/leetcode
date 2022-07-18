package cn.njust.leetcode.JZOffer;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

import java.util.EnumSet;
import java.util.HashSet;

public class JZ3 {
    public int duplicate (int[] numbers) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i< numbers.length;i++){
            int tmp = numbers[i];
            if(!set.contains(tmp)){
                set.add(tmp);
            }else{
                return tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        int res = new JZ3().duplicate(nums);
        System.out.println(res);
    }
}
