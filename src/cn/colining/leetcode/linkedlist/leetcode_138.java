package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by colin on 2017/7/10.
 */
public class leetcode_138 {
    /**
     * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
     Return a deep copy of the list.
     * @param args
     */
    public static void main(String[] args) {
        RandomListNode randomListNode = new RandomListNode(-1);
        randomListNode.random = new RandomListNode(0);
        copyRandomList(randomListNode);
    }

    /**
     * 复杂链表的复制，一定要注意指针；先复制一份结点
     * 然后通过复制结点复制random指针
     * @param head
     * @return
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode node = head;
        RandomListNode temp = null;
        while (node != null) {
            temp = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = temp;
            node = temp;
        }

        node = head;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        node = head;
        RandomListNode newHead = head.next;
        while (node != null) {
            temp = node.next;
            node.next = node.next.next;
            temp.next = node.next == null ? null : node.next.next;
            node = node.next;
        }
        return newHead;
    }

    /**
     * Hash表的做法；非常易懂
     * @param head
     * @return
     */
    public static RandomListNode copyRandomList1(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}


class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

