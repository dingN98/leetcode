package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/5 22:21
 * 023 合并k个升序列表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Test1205b {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len==0){
            return null;
        }
        if(len==1){
            return lists[0];
        }
        ListNode res = null;
        for(int i=0;i<len;i++){
            res = mergeTwo(res,lists[i]);
        }
        return res;
    }

    public ListNode mergeTwo(ListNode l1,ListNode l2){
        ListNode res = new ListNode();
        ListNode tail = res;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        tail.next = l1==null?l2:l1;
        return res.next;
    }



}
