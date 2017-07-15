package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

/**
 * Created by colin on 2017/7/13.
 */
public class leetcode_82 {
    /**
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

     For example,
     Given 1->2->3->3->4->4->5, return 1->2->5.
     Given 1->1->1->2->3, return 2->3.
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = ListNode.buildListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        deleteDuplicates(node);
    }

    /**
     * 1. 如果结点重复，就向后寻找不相同的第一个结点
     * 2. pre指针的next指向这个结点，将重复结点跳过
     * 3. 当当前结点后面的结点不重复的时候，pre指针就可以向后移动了
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currentNode = head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode next;
        while (currentNode != null && currentNode.next!=null) {
            next = currentNode.next;
            if (currentNode.val == currentNode.next.val) {
                while (next != null && next.val == currentNode.val) {
                    next = next.next;
                }
                pre.next = next;
                currentNode = next;
            }else {
                pre = currentNode;
                currentNode = next;
            }

        }
        return newHead.next;
    }

}
