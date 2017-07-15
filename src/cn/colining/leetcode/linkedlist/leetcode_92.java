package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

/**
 * Created by colin on 2017/7/11.
 */
public class leetcode_92 {
    /*
    Reverse a linked list from position m to n. Do it in-place and in one-pass.

    For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,

    return 1->4->3->2->5->NULL.

    Note:
    Given m, n satisfy the following condition:
    1 ? m ? n ? length of list.
     */
    public static void main(String[] args) {
        ListNode node = ListNode.buildListNode(new int[]{1,2,3,4,5,6,7,8,9});
        reverseBetween1(node, 4,6);
    }

    /**
     * 解法一：移动结点，达到reverse目的
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null ) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode preCopy = pre;
        //找到应该reverse的第一个结点的前一个结点
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;

        //通过每次从后往前调换位置，即可部分逆序
        for (int i = 0; i < n-m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return preCopy.next;

    }


    /**
     * 自己写的反转指针的做法，好麻烦
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode headCopy = new ListNode(0);
        headCopy.next = head;
        ListNode node = headCopy;
        int i = 0;
        ListNode preLeft = headCopy;
        ListNode right = null;
        while (node != null) {
            if (i == m - 1) {
                preLeft = node;
            }
            if (i == n) {
                right = node;
            }
            i++;
            node = node.next;
        }
        if (i < m) {
            return null;
        }
        reverseList(preLeft, preLeft.next, right, right.next);

        return headCopy.next;
    }

    public static ListNode reverseList(ListNode preHead, ListNode head, ListNode tail, ListNode afterTail) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode headCopy = head;
        ListNode temp = null;
        while (cur != afterTail) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        headCopy.next = afterTail;
        preHead.next = pre;
        return pre;
    }
}
