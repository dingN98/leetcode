package cn.njust.leetcode.NiuKe.链表;

import cn.njust.leetcode.JZOffer.ListNode;

import java.util.PriorityQueue;

public class BM8 {

    // BM8 链表中倒数最后k个结点
    // 双指针（滑动窗口）
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;
        for(int i=0;i<k;i++){
            if(fast==null){
                return null;
            }
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
