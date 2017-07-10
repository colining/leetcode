package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

/**
 * Created by colin on 2017/7/10.
 */
public class leetcode_141 {
    /**
     * Given a linked list, determine if it has a cycle in it.

     Follow up:
     Can you solve it without using extra space?
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }
}
