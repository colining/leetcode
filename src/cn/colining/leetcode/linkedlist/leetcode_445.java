package cn.colining.leetcode.linkedlist;

import cn.colining.myjar.ListNode;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.List;
import java.util.Stack;

/**
 * Created by colin on 2017/7/8.
 */
public class leetcode_445 {
    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The most significant digit comes first and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     Follow up:
     what if you cannot modify the input lists? In other words, reversing the lists is not allowed.
     Example:
     Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 8 -> 0 -> 7
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(7);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(1);

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);

        addTwoNumbers1(listNode.next.next.next, listNode1.next);
    }

    /**
     * 思路其实很好想，就是通过两个栈，从尾到头计算链表<br>
     * 问题其实出现在创建新链表；如果在原本的链表进行处理会比较复杂
     * @param node1Head
     * @param node2Head
     * @return
     */
    public static ListNode addTwoNumbers(ListNode node1Head, ListNode node2Head) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (node1Head != null) {
            stack1.add(node1Head);
            node1Head = node1Head.next;
        }
        while (node2Head != null) {
            stack2.add(node2Head);
            node2Head = node2Head.next;
        }
        int temp = 0;
        ListNode head = null;
        while (!(stack1.empty() && stack2.empty())) {
            int value1 = stack1.empty() ? 0 : stack1.pop().val;
            int value2 = stack2.empty() ? 0 : stack2.pop().val;
            int sum = temp+value1 + value2;
            temp = 0;
            if (sum >= 10) {
                temp = 1;
            }
            sum %= 10;
            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;
        }
        if (temp == 1) {
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        //list 是活动结点，由于链表是向前增加的
        //所以每次回新创建一个head结点；
        //当head结点值为1时，说明最前面有进位
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }
}
