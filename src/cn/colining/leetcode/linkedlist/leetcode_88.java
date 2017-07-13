package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

/**
 * Created by colin on 2017/7/13.
 */
public class leetcode_88 {
    public static void main(String[] args) {
        ListNode node = ListNode.buildListNode(new int[]{1, 4, 3, 2, 5, 2});
        partition(node, 3);
    }
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode smallCopy = small;
        ListNode big = new ListNode(0);
        ListNode bigCopy = big;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                big.next = head;
                big = big.next;
            }
            head = head.next;

        }
        big.next = null;
        small.next = bigCopy.next;
        return smallCopy.next;
    }
}
