package cn.njust.leetcode.Huawei0920;

import cn.njust.leetcode.JZOffer.ListNode;

public class LK206 {

    // 206. 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode head2 = null;
        while(head!=null){
            ListNode tmp = head.next;
            if(head2==null){
                head2 = head;
                head2.next = null;
            }else{
                head.next = head2;
                head2 = head;
            }
            head = tmp;
        }
        return head2;
    }
}
