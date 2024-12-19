package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/18 19:56
 * 061 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
public class Test1218c {

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }

        int len = 1;
        ListNode h2 = head;

        while(h2.next!=null){
            h2 = h2.next;
            len++;
        }
        ListNode tail = h2;

        if(k%len==0){
            return head;
        }

        h2 = head;
        for(int i=0;i<(len-k%len)-1;i++){
            h2 = h2.next;
        }

        ListNode h3 = h2.next;
//        System.out.println("h3.val="+h3.val);
        h2.next = null;
        tail.next = head;
        return h3;
    }

    public static void main(String[] args) {
        Test1218c t = new Test1218c();

        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = null;

        ListNode h = t.rotateRight(h1, 2);
        while(h!=null){
            System.out.print(h.val+",");
            h = h.next;

        }

    }
}
