package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

/**
 * Created by colin on 2017/7/11.
 */
public class leetcode_206 {
    /**
     * Reverse a singly linked list.
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6});
        reverseList1(node);
    }

    /**
     * 翻转指针的做法
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 递归的做法，其实简单想来就是先把每一个结点拿出来，然后反转链表；
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead =reverseList1(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    /**
     * 反转某一部分，但是连接回原来的链表依旧是个问题
     * @param head
     * @param tail
     * @return
     */
    public static ListNode reverseList(ListNode head,ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != tail) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}
