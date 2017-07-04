package cn.colining.bat.linkedlist;

import java.util.Stack;

/**
 * Created by colin on 2017/7/4.
 */
public class KInverse {
    /**
     * 有一个单链表，请设计一个算法，使得每K个结点之间逆序，如果最后不够K个结点一组，
     * 则不调整最后几个结点。例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。
     * 调整后为，3->2->1->6->5->4->7->8->null。因为K==3，所以每三个结点之间逆序，
     * 但其中的7，8不调整，因为只有两个结点不够一组。
     * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 我只能说我绝对不会写这道题，说白了就是在调链表指针，一丁点意义都没有
     * @param head
     * @param k
     * @return
     */
    public ListNode inverse(ListNode head, int k) {
        if (k < 2)
            return head;
        ListNode cur = head, pre = null, start = null, next = null;
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == k) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    private void resign(ListNode left, ListNode start, ListNode end, ListNode right) {
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode next = null;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }
}
