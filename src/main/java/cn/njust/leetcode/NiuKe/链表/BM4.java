package cn.njust.leetcode.NiuKe.链表;

import cn.njust.leetcode.JZOffer.ListNode;

public class BM4 {

    // BM4 合并两个排序的链表
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode head = null;
        ListNode tail = null;
        while(list1!=null && list2!=null){
            int v1 = list1.val;
            int v2 = list2.val;
            if(v1<v2){
                if(head == null){
                    head = new ListNode(v1);
                    tail = head;
                }else{
                    tail.next = new ListNode(v1);
                    tail = tail.next;
                }
                list1 = list1.next;
            }else{
                if(head == null){
                    head = new ListNode(v2);
                    tail = head;
                }else{
                    tail.next = new ListNode(v2);
                    tail = tail.next;
                }
                list2 = list2.next;
            }
        }
        tail.next = Merge(list1,list2);
        return head;

    }

    public static void main(String[] args) {

    }
}
