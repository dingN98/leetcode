package cn.njust.leetcode.NiuKe.链表;

import cn.njust.leetcode.JZOffer.ListNode;

public class BM4_2 {

    // BM4 合并两个排序的链表
    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while(list1!=null && list2!=null){
            int v1 = list1.val;
            int v2 = list2.val;
            if(v1<v2){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1==null){
            tail.next = list2;
        }
        if(list2==null){
            tail.next = list1;
        }
        return head.next;

    }

    public static void main(String[] args) {

    }
}
