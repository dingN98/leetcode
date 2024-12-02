package cn.njust.leetcode.JZOffer;

import java.util.HashMap;

public class JZ23_2 {

    // 链表中环的入口结点
    // 方法一：使用HashMap记录已经出现的节点
    // 但是 题目要求空间复杂度是  O(1)
    // 使用方法二  快慢指针，快指针每次走2步，慢指针每次走1步。他们第一次相遇后，快指针回到起点，二者每次都走1步。
    // 第二次相遇的位置就是  环的入口
    // 原因的话，可以用数学证明


    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast!=null){
            slow = slow.next;
            if(fast.next==null){
                return null;
            }
            fast = fast.next.next;
            if(fast==slow){
                // 二者会在环的某一点相遇，不一定是环的入口位置
                fast = pHead;
                while(fast!=slow){
                    // 第二次相遇 一定在环的入口位置
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

}
