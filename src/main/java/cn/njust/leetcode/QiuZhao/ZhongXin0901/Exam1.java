package cn.njust.leetcode.QiuZhao.ZhongXin0901;

public class Exam1 {

    static class ListNode {
         int val;
         ListNode next = null;
         public ListNode(int val) {
            this.val = val;
         }
     }

    public ListNode mergeNode (ListNode head) {
        // write code here
        ListNode newHead = null;
        ListNode newTmp = null;
        while(true){
            ListNode tmp = head;
            ListNode tmp2 = tmp.next;
            ListNode tmp3 = tmp2.next;
            if(newHead==null){
                newHead = new ListNode(tmp.val*tmp2.val);
                newTmp = newHead;
            }else{
                newTmp.next = new ListNode(tmp.val*tmp2.val);
                newTmp = newTmp.next;
            }
            if(tmp3==null){
                newTmp.next = null;
                break;
            }
            head = tmp3;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(5);
        ListNode h4 = new ListNode(1);
        ListNode h5 = new ListNode(4);
        ListNode h6 = new ListNode(7);
        head.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        ListNode res = new Exam1().mergeNode(head);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
