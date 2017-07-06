package cn.colining.bat.linkedlist;

/**
 * Created by colin on 2017/7/6.
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3;
        node2.random = node1;

        Clone(node1);
    }
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode node = pHead;
        RandomListNode next = null;
        RandomListNode nodeCopy;
        while (node != null) {
            next = node.next;
            nodeCopy = new RandomListNode(node.label);
            node.next = nodeCopy;
            nodeCopy.next = next;
            node = next;
        }

        node = pHead;
        while (node != null) {
            node.next.random = node.random;
            node = node.next.next;
        }

        node = pHead;
        RandomListNode result = node.next;

        while (node != null) {
            next = node.next.next;
            node.next.next = next == null ? null : next.next;
            node.next = next;

            node = next;
        }
        return result;
    }
}
