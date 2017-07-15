package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

/**
 * Created by colin on 2017/7/9.
 */
public class leetcode_2 {
    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 8};
        int[] array1 = new int[]{0};
        ListNode node1 = ListNode.buildListNode(array);
        ListNode node2 = ListNode.buildListNode(array1);
        addTwoNumbers1(node1, node2);
    }

    /**
     * 这个是445的初级版，只需要从头到尾做加法就可以了<br>
     * 我写了两个，一个是添加当前结点，一个是添加下一个结点；
     * 没啥区别；
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode headCopy = head;
        ListNode node ;
        ListNode temp = null;
        int sum = 0;
        while (!(node1 == null && node2 == null)) {
            int value1 = node1 == null ? 0 : node1.val;
            int value2 = node2 == null ? 0 : node2.val;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
            sum += (value1 + value2);
            head.val = sum % 10;
            node = new ListNode(sum / 10);
            head.next = node;
            temp = head;
            head = node;
            sum /= 10;
        }
        if (head.val == 0) {
            temp.next = null;
        }
        return headCopy;
    }

    public static ListNode addTwoNumbers1(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode headCopy = head;
        int sum = 0;
        while (!(node1 == null && node2 == null)) {
            if (node1 != null) {
                sum += node1.val;
                node1 = node1.next;
            }
            if (node2 != null) {
                sum += node2.val;
                node2 = node2.next;
            }
            ListNode next = new ListNode(sum % 10);
            head.next = next;
            head = next;
            sum /= 10;
        }
        if (sum == 1) {
            head.next = new ListNode(1);
        }
        return headCopy.next;
    }

}
