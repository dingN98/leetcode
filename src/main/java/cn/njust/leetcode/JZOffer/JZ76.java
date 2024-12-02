package cn.njust.leetcode.JZOffer;

import java.util.HashMap;

public class JZ76 {

    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表 1->2->3->3->4->4->5  处理后为 1->2->5

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null || pHead.next==null){
            return pHead;
        }

        ListNode head = pHead;
        ListNode head2 = pHead.next;
        ListNode before = pHead;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(pHead!=null){
            int key = pHead.val;
            if(map.containsKey(key)){
                map.put(key,1+map.get(key));
            }else{
                map.put(key,1);
            }
            pHead = pHead.next;
        }

        // 从第二个节点开始尝试比对 删除
        while(head2!=null){
            int key = head2.val;
            if(map.get(key)>1){
                before.next = head2.next;
            }else{
                before = head2;
            }
            head2 = head2.next;
        }

        // 最后判断head
        if(map.get(head.val)==1){
            return head;
        }else{
            return head.next;
        }
    }
}
