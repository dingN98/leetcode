package cn.njust.leetcode.JZOffer;

public class JZ18_2 {
    static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode deleteNode (ListNode head, int val) {

        ListNode head2 = head;

        if(head.val==val){
            return head.next;
        }
        while(head.next.val!=val){
            head = head.next;
        }
        head.next = head.next.next;

        return head2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode h1 = new ListNode(5);
        ListNode h2 = new ListNode(1);
        ListNode h3 = new ListNode(9);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;

        int val = 5;
        ListNode head2 = new JZ18_2().deleteNode(head,val);
        while(head2!=null){
            System.out.print(head2.val+" ");
            head2 = head2.next;
        }
    }
}
