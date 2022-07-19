package cn.njust.leetcode.JZOffer;

public class JZ22 {

    static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode FindKthToTail (ListNode pHead, int k) {

        int len = 0;
        ListNode head = pHead;
        while(head!=null){
            len++;
            head = head.next;
        }

        if(k>len){
            return null;
        }
        k = len - k;
        while(k>0){
            pHead = pHead.next;
            k--;
        }

        return pHead;
    }
}
