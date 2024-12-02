package cn.njust.leetcode.NiuKe.链表;

import cn.njust.leetcode.JZOffer.ListNode;

public class BM1 {

    // 反转链表  简单题
    public ListNode ReverseList(ListNode head) {

        ListNode headNew = null;

        while(head!=null){
            ListNode tmp = head.next;
            head.next = headNew;
            headNew = head;
            head = tmp;
        }
        return headNew;


    }

    public static void main(String[] args) {

    }
}
