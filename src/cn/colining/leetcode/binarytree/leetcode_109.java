package cn.colining.leetcode.binarytree;

import cn.colining.myjar.ListNode;
import cn.colining.myjar.TreeNode;

/**
 * Created by colin on 2017/7/10.
 */
public class leetcode_109 {
    /**
     * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        sortedListToBST(node);
    }

    /**
     * 和数组几乎一样，只不过寻找中位数比较特别；
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        TreeNode node = buildBSTByLIst(head, null);
        return node;
    }

    private static TreeNode buildBSTByLIst(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode quick = head;
        ListNode slow = head;
        while (quick != tail && quick.next != tail) {
            quick = quick.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = buildBSTByLIst(head, slow);
        node.right = buildBSTByLIst(slow.next, tail);

        return node;
    }
}
