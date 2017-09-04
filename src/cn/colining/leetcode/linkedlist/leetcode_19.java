package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

import java.util.Scanner;

/**
 * Created by colin on 2017/9/4.
 */
public class leetcode_19 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        System.out.println(removeNthFromEnd(listNode, 4).val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headBack = new ListNode(0);
        headBack.next = head;
        ListNode cur = head;
        ListNode helper = headBack;
        for (int i = 0; i < n; i++) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }
        while (cur!= null) {
            cur = cur.next;
            helper = helper.next;
        }
        helper.next = helper.next.next;
        return headBack.next;
    }
}
