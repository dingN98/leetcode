package cn.cetc28.leetcode;

/**
 * @author dingnan98
 * @project leetcode
 * @date 2024/12/4 23:00
 * 021 合并两个有序列表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Test1204e {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode tail = res;
        while (list1!=null && list2!=null){
            if(list1.val< list2.val){
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        tail.next=list1==null?list2:list1;
//        while(list1!=null || list2!=null){
//            if(list1!=null && list2!=null){
//                int n1 = list1.val;
//                int n2 = list2.val;
//                if(n1<n2){
//                    list1 = list1.next;
//                }else{
//                    list2 = list2.next;
//                }
//                ListNode tmp = new ListNode(Math.min(n1,n2));
//                tail.next = tmp;
//                tail = tmp;
//            }else if(list1!=null){
//                tail.next = list1;
//                break;
//            }else{
//                tail.next = list2;
//                break;
//            }
//        }
        return res.next;

    }

}

