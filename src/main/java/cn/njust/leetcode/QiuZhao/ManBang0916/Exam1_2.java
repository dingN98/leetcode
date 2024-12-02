package cn.njust.leetcode.QiuZhao.ManBang0916;

import cn.njust.leetcode.JZOffer.ListNode;

public class Exam1_2 {

    public ListNode merge(ListNode head){
//        ListNode head2 = null;
        ListNode tmp = null;
        ListNode head2 = head;

        while(head!=null){
            ListNode h1 = head;
            ListNode h2 = head.next;
            h1.val = h1.val*h2.val;
            if(tmp==null){
                tmp = h1;
            }else{
                tmp.next = h1;
                tmp = tmp.next;
            }
            head = h2.next;
        }
        tmp.next = null;
        return head2;

    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        ListNode res = new Exam1_2().merge(h1);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
