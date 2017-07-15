package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;
import javafx.scene.Node;

import java.util.Stack;

/**
 * Created by colin on 2017/7/10.
 */
public class leetcode_143 {
    /**
     * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
     * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
     * You must do this in-place without altering the nodes' values.
     * For example,
     * Given{1,2,3,4}, reorder it to{1,4,2,3}.
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        reorderList1(node);
    }

    /**
     * 最初的想法就是建栈然后再边弹出，边连接
     * 好处是不用处理那么多的指针，坏处就是并过不了leetcode
     *
     * @param head
     * @return
     */
    public static ListNode reorderList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head;
        int n = stack.size() >> 1;
        for (int i = 0; i < n; i++) {
            ListNode temp = node.next;
            node.next = stack.pop();
            node.next.next = temp;
            node = temp;
        }
        node.next = null;
        return head;
    }

    /**
     * 思路二：先将后半部分的结点反转，然后就是连接；
     * 难点就是在于指针的操作；写的简单吧，就难以理解；
     * 所以我还是按照我的想法写了一个容易懂得；
     * @param head
     */
    public static void reorderList1(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode quick = head;
        ListNode slow = head;
        ListNode beforeSlow = head;
        //寻找中点
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            beforeSlow = slow;
            slow = slow.next;
        }
        ListNode curNode = slow;
        ListNode pre = null;
        ListNode temp = null;
        //将后半部分反转
        while (curNode != null) {
            temp = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = temp;
        }
        //连接结点的一种方法，不过有点难懂
//        beforeSlow.next = pre;
//        curNode = head;
//        while (curNode != beforeSlow) {
//            beforeSlow.next = pre.next;
//            pre.next = curNode.next;
//            curNode.next = pre;
//            curNode = pre.next;
//            pre = beforeSlow.next;
//        }
        //自己的思路，先是把两边分开，然后连起来
        beforeSlow.next = null;
        curNode = head;
        ListNode temp2 = null;
        ListNode node = null;
        while (curNode != null) {
            temp = curNode.next;
            curNode.next = pre;
            node = curNode;
            curNode = temp;
            temp = pre.next;
            pre.next = curNode;
            pre = temp;
        }
        //最后要进行判断，因为可能就会落下一个
        if (pre != null) {
            node.next.next = pre;
        }

        return;
    }



}
