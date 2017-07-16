package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

import java.time.Period;

/**
 * Created by colin on 2017/7/13.
 */
public class leetcode_83 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = ListNode.buildListNode(new int[]{1, 1, 2, 2, 3, 4});
        deleteDuplicates(node);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode headCopy = new ListNode(0);
        headCopy.next = head;
        ListNode pre = headCopy;
        ListNode currentNode = head;
        while (currentNode != null) {
            while (currentNode.next != null && currentNode.val == currentNode.next.val) {
                currentNode = currentNode.next;
            }
            pre.next = currentNode;
            pre = currentNode;
            currentNode = currentNode.next;
        }
        return headCopy.next;
    }

    /**
     * 若遇到相同结点，就将next往下移动，然后比较
     * 这样最后就找到一个不同的结点，并且已经连接好了
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            }else {
                curNode = curNode.next;
            }
        }
        return head;
    }
}
