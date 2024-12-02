package cn.njust.leetcode.NiuKe.链表;

import cn.njust.leetcode.JZOffer.ListNode;

import java.util.ArrayList;

public class BM13 {

    // BM13 判断一个链表是否为回文结构
    // 将链表的值输入到一个数组里  辅助判断
    public boolean isPail (ListNode head) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size()-1;
        while(left<right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;


    }
}
