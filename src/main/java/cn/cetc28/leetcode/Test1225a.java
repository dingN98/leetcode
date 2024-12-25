package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/25 23:26
 * 082 删除排序链表中的重复元素II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 */
public class Test1225a {

    public ListNode deleteDuplicates(ListNode head) {


        ListNode res = null;
        ListNode last = null;
        ListNode now = head;
        int cnt = 0;
        while(now!=null){
            cnt=0;
            while(now.next!=null && now.val==now.next.val){
                now = now.next;
                cnt++;
            }
            if(cnt>0){
                now = now.next;
            }else{
                if(res==null){
                    res=now;
                    last = now;
                }else{
                    last.next = now;
                    last = now;
                }
                now = now.next;
            }
        }
        if(last!=null){
            last.next = null;
        }
        return res;


    }

    public static void main(String[] args) {

    }
}
