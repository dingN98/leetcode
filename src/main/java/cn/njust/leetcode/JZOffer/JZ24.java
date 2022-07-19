package cn.njust.leetcode.JZOffer;

public class JZ24 {

    public ListNode ReverseList(ListNode head) {

        if(head==null){
            return null;
        }
        // nextN 记录 head 的下一个节点。因为反转 head 的指向会导致 head 的next 丢失，所以需要保存。
        ListNode preN = null;
        ListNode nextN = null;

        while(head!=null){
            nextN = head.next;
            head.next = preN;
            preN = head;
            head =nextN;
        }
        return preN;

    }

    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        ListNode h1 = new ListNode(5);
        ListNode h2 = new ListNode(1);
        ListNode h3 = new ListNode(9);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;

        ListNode head2 = new JZ24().ReverseList(head);

        while(head2!=null){
            System.out.print(head2.val+" ");
            head2 = head2.next;
        }


    }
}
