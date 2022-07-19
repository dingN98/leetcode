package cn.njust.leetcode.JZOffer;

public class JZ25 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode head2 = head;
        while(list1!=null && list2!=null){
            if(list1.val>= list2.val){
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }else{
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            head = head.next;
        }
        if(list1==null){
            head.next = list2;
        }else{
            head.next = list1;
        }
        return head2.next;
    }
}
