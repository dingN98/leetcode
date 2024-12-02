package cn.njust.leetcode.JZOffer;

import java.util.HashMap;

public class JZ23 {

    // 链表中环的入口结点
    // 方法一：使用HashMap记录已经出现的节点

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashMap<Integer,Integer> map = new HashMap<>();
        while(pHead!=null){
            int val = pHead.val;
            if(map.containsKey(val)){
                return pHead;
            }else{
                map.put(val,1);
                pHead = pHead.next;
            }
        }
        return null;


    }

}
