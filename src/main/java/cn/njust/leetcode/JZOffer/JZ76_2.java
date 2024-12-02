package cn.njust.leetcode.JZOffer;

import java.util.HashMap;

public class JZ76_2 {

    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表 1->2->3->3->4->4->5  处理后为 1->2->5

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null || pHead.next==null){
            return pHead;
        }
        // 至少俩节点
        int v = 0;
        ListNode tmp = pHead;
        ListNode before = pHead;
        while(tmp!=null){
            int v1 = tmp.val;
            int v2 = 0;
            if(tmp.next!=null){
                v2 = tmp.next.val;
            }
            if(v1==v2){
                v = v1;
            }

            if(v1==v){
                if(tmp==pHead){
                    // 删除头节点
                    pHead = pHead.next;
                    before = pHead;
                }else{
                    // 删除该节点
                    before.next = tmp.next;
                }
            }else{
                before = tmp;
            }
            tmp = tmp.next;
        }
        return pHead;
    }
}
