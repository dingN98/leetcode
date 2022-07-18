package cn.njust.leetcode.JZOffer;
import java.util.ArrayList;

public class JZ6 {

    static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> res = new ArrayList<>();
        while(listNode!=null){
            res.add(0,listNode.val);
            listNode = listNode.next;
        }
        return res;
    }
}
