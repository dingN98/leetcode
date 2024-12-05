package cn.cetc28.leetcode;

import org.springframework.aop.target.dynamic.AbstractRefreshableTargetSource;

import javax.lang.model.type.ErrorType;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/5 22:32
 * 024 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class Test1205c {

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Test1205c t = new Test1205c();
        ListNode res = t.swapPairs(n1);
        t.printListNode(res);



    }

    public void printListNode(ListNode l){
        StringBuffer s = new StringBuffer();
        while(l!=null){
            s.append(l.val);
            l = l.next;
        }
        System.out.println(s.toString());
    }

    public ListNode swapPairs(ListNode head) {
        //  1 2 3 4 ->  2 1 4 3
        // -1  1  2  3   4 ->  -1 2 1 3 4  ->   -1 2 1 4 3
        // l1 l2 l3 l4
        ListNode head2 = new ListNode(-1);
        head2.next = head;
        ListNode now = head2;

        while(now!=null){
            ListNode l1 = now;
            ListNode l2 = l1.next;
            ListNode l3 = null;
            ListNode l4 = null;
            if(l2!=null){
                l3 = l2.next;
                if(l3!=null){
                    l4 = l3.next;
                }
            }
            if(l2==null || l3==null){
                break;
            }

            l1.next = l3;
            l3.next = l2;
            l2.next = l4;
            now = now.next.next;
        }
        return head2.next;

    }
}
