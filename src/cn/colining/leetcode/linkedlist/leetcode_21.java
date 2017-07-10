package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

/**
 * Created by colin on 2017/7/10.
 */
public class leetcode_21 {
    /**
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = ListNode.buildListNode(new int[]{1, 3, 5, 7, 9});
        ListNode node1 = ListNode.buildListNode(new int[]{2, 4, 6, 7, 10});
        mergeTwoLists(node, node1);
    }

    /**
     * 合并两个链表，没什么好说的
     * 不过我突然意识到这是归并排序的合并步骤
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                result.next = head1;
                head1 = head1.next;
            }else {
                result.next = head2;
                head2 = head2.next;
            }
            result = result.next;
        }
        if (head1 != null) {
            result.next = head1;
        }
        if (head2 != null) {
            result.next = head2;
        }
        return head.next;
    }
}
