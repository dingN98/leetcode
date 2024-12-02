package cn.njust.leetcode.NiuKe.链表;

import cn.njust.leetcode.JZOffer.ListNode;

public class BM15 {

    // BM15 删除有序链表中重复的元素-I
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode head2 = new ListNode(-1000);
        ListNode tail = head2;
        while(head!=null){
            if(head.val != tail.val){
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }
        tail.next = null;
        return head2.next;
    }
}
