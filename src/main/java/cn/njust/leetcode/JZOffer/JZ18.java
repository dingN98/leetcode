package cn.njust.leetcode.JZOffer;

public class JZ18 {
    static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode deleteNode (ListNode head, int val) {
        // tmp在前 tmp2在后
        ListNode tmp = head;
        ListNode tmp2 = head;
        while(tmp2!=null){
            if(tmp2.val==val){
                if(tmp2==head){
                    return tmp2.next;
                }else{
                    tmp.next = tmp2.next;
                    return head;
                }
            }
            if(tmp2==head){
                // 初始只有 tmp2 后移
                tmp2 = tmp2.next;
                continue;
            }
            tmp = tmp.next;
            tmp2 = tmp2.next;
        }

        return null;
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
        ListNode head2 = new JZ18().deleteNode(head,val);
        while(head2!=null){
            System.out.print(head2.val+" ");
            head2 = head2.next;
        }
    }
}
