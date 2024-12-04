package cn.cetc28.leetcode;

import java.util.HashMap;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/4 22:24
 * 019 删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Test1204c {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;
        Test1204c t = new Test1204c();
        ListNode res = t.removeNthFromEnd(n1,2);
        t.print(res);
    }

    public void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer,ListNode> map = new HashMap<>();
        ListNode tail = head;
        int len = 0;
        while (tail!=null){
            len++;
            map.put(len,tail);
            tail = tail.next;
        }
        if(n>len){
            return head;
        }
        // 删除正数第index个节点
        int index = len-n+1;
        if(index==1){
            return head.next;
        }
        if(index==len){
            if(len<=1){
                return null;
            }else{
                map.get(index-1).next = null;
                return head;
            }
        }
        map.get(index-1).next = map.get(index+1);
        return head;

    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
