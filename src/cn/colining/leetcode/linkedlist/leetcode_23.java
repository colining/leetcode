package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by colin on 2017/9/4.
 */
public class leetcode_23 {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val == o2.val) {
                return 0;
            }
            return o1.val > o2.val ? 1 : -1;
        });
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
