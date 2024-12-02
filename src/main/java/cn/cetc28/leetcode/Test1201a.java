package cn.cetc28.leetcode;


import cn.njust.leetcode.JZOffer.ListNode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/1 20:30
 * 002 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Test1201a {

    public static void main(String[] args) {

        Test1201a t = new Test1201a();

        int[] nums1 = {2,4,3};
        int[] nums2 = {5,6,4};
        ListNode l1 = t.makeListNode(nums1);
        ListNode l2 = t.makeListNode(nums2);
        t.printListNode(l1);
        t.printListNode(l2);
        t.printListNode(t.addTwoNumbers(l1,l2));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 就是链表同位置，两个数字求和，加上一个进位
        // 忘了考虑最高位的进位如果是1 结果链表的长度会增加1位
        // 时间复杂度 O（N） 空间复杂度 O(N)
        // 官方解答时间复杂度是 O(max(l1.len,l2.len))   空间复杂度 O(1) 解释 注意返回值不计入空间复杂度。
        int jinWei = 0;
        int sum = 0;
        ListNode l3 = new ListNode();
        ListNode last = l3;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                sum = l1.val+l2.val+jinWei;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1!=null){
                sum = l1.val+jinWei;
                l1 = l1.next;
            }else{
                sum = l2.val+jinWei;
                l2 = l2.next;
            }

            jinWei = sum/10;
            sum = sum % 10;

            ListNode tmp = new ListNode(sum,null);
            last.next = tmp;
            last = tmp;
        }
        // 最后判断进位是否是1  这种情况我第一次没考虑到
        if(jinWei == 1){
            ListNode tmp = new ListNode(1,null);
            last.next = tmp;
        }
        return l3.next;
    }

    public ListNode makeListNode(int[] nums){
        int len = nums.length;
        int i = len-1;
        ListNode head = new ListNode();
        ListNode last = head;
        while (i>=0){
            ListNode tmp = new ListNode(nums[i],null);
            last.next = tmp;
            last = tmp;
            i--;
        }
        return head.next;
    }

    public void printListNode(ListNode l){
        StringBuffer s = new StringBuffer();
        while(l!=null){
            s.append(l.val);
            l = l.next;
        }
        System.out.println(s.toString());
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }



}
