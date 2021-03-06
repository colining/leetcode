package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

/**
 * Created by colin on 2017/7/10.
 */
public class leetcode_142 {
    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

     Note: Do not modify the linked list.

     Follow up:
     Can you solve it without using extra space?
     * @param head
     * @return
     */

    public ListNode detectCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        //找到快慢指针的相交点
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                quick =head;
                break;
            }
        }
        if(quick == null||quick.next ==null)
            return null;
        //快慢指针一步一步走，会在环的起始位置相遇
        while (quick != slow) {
            quick = quick.next;
            slow = slow.next;
        }
        return quick;
    }
}
