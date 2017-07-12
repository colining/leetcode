package cn.colining.leetcode.sort;

import cn.colining.myjar.ListNode;

/**
 * Created by colin on 2017/7/11.
 */
public class leetcode_147 {
    /*
    Sort a linked list using insertion sort.
     */
    public static void main(String[] args) {
        ListNode node = ListNode.buildListNode(new int[]{3, 2, 1, 4});
        insertionSortList(node);
    }

    /**
     * 插入排序思想的关键是向一个有序的序列进行排序，最普通的我们
     * 从第一个元素认为是有序的，然后从后面加入元素；
     * 对于这道题而言，链表并不能知道前面的元素，从后向前排也很困难
     * 所以我们等于新建了一个链表；然后每次从原链表取元素，与新链表的元素进行比较
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headCopy = new ListNode(0);
        ListNode currentNode = head;
        ListNode pre = headCopy;
        ListNode next = null;
        while (currentNode != null) {
            next = currentNode.next;
            while (pre.next != null && pre.next.val < currentNode.val) {
                pre = pre.next;
            }
            currentNode.next = pre.next;
            pre.next = currentNode;
            pre = headCopy;
            currentNode = next;
        }
        return headCopy.next;
    }
}
