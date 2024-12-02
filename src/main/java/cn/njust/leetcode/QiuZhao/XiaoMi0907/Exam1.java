package cn.njust.leetcode.QiuZhao.XiaoMi0907;

import cn.njust.leetcode.JZOffer.ListNode;

public class Exam1 {

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode head2 = head;
        ListNode before = head;
        if(head==null || head.next==null){
            return head;
        }
        int v = 0;

        while(head!=null){
            int v1 = head.val;
            int v2 = 0;
            if(head.next!=null){
                v2 = head.next.val;
            }
            if(v1==v2){
                v = v1;
            }
            if(v1==v){
                // 删除
                if(head==head2){
                    // 删除head
                    head2 = head.next;
                    before = head2;
                }else{
                    before.next = head.next;
                }
            }else{
                before = head;
            }
            head = head.next;
        }
        return head2;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode res = new Exam1().deleteDuplicates(l1);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }



    }
}
