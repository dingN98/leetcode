package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/26 19:53
 * 083 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class Test1226 {

    public ListNode deleteDuplicates(ListNode head) {
        // 1 1 2 3
        ListNode now = head;
        while (now !=null && now.next!=null){
            if(now.val==now.next.val){
                now.next = now.next.next;
            }else{
                now = now.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {

    }
}
