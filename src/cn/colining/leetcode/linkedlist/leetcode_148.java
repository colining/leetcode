package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

/**
 * Created by colin on 2017/7/9.
 */
public class leetcode_148 {
    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = ListNode.buildListNode(new int[]{2,2,2,2,2,1,2,2,2,2});
        ListNode node2 = ListNode.buildListNode(new int[]{3, 4, 6, 10});
        ListNode result = sortList(node1);
        System.out.println(result);
    }

    /**
     * O(nlogn) 那就是归并，堆排，快排了呗；<br>
     * 对于链表来说，又不能通过下标来访问，所以归并是最好的选择<br>
     * 而且做起来也很容易，我以为很难呢<br>
     * 注意1：链表中点需要快慢指针来寻找<br>
     * 注意2：链表需要真实的截断；<br>
     * 注意3：合并的时候，剩余的部分只要连起来就行了，不用循环<br>
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        ListNode cut = null;
        while (quick != null && quick.next != null) {
            cut = slow;
            slow = slow.next;
            quick = quick.next.next;
        }
        cut.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);

        return merge(node1, node2);
    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        if (node1 != null) {
            temp.next = node1;
        }
        if (node2 != null) {
            temp.next = node2;
        }

        return head.next;
    }

}
