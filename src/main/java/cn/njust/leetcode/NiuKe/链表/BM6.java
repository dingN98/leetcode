package cn.njust.leetcode.NiuKe.链表;

import cn.njust.leetcode.JZOffer.ListNode;

public class BM6 {

    // 判断链表是否有环
    // 快慢指针

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            if(fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
