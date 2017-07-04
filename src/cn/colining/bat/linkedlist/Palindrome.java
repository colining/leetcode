package cn.colining.bat.linkedlist;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by colin on 2017/7/4.
 */
public class Palindrome {
    /**
     * 请编写一个函数，检查链表是否为回文。
     * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
     * @param args
     */
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 3, 2, 1};
        ListNode head1Back = getListNode(array1);
        System.out.println(isPalindrome1(head1Back));
    }

    public static ListNode getListNode(int[] array1) {
        ListNode head1 = new ListNode(0);
        ListNode head1Back1 = head1;
        for (int i = 0; i < array1.length; i++) {
            head1.next = new ListNode(array1[i]);
            head1 = head1.next;
        }
        return head1Back1.next;
    }

    /**
     * 通过快慢指针找到链表中间<br>
     * 然后将中间以后反转；呈现出两边一起指向中间；<br>
     * 然后左右一起向中间遍历
     * @param pHead
     * @return
     */
    public static boolean isPalindrome(ListNode pHead) {
        ListNode quick = pHead;
        ListNode slow = pHead;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode pre = reverseList(slow);
        slow.next = null;
        while (pHead != null) {
            if (pHead.val != pre.val)
                return false;
            pHead = pHead.next;
            pre = pre.next;
        }
            return true;
    }

    private static ListNode reverseList(ListNode slow) {
        ListNode current = slow.next;
        ListNode pre = slow;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }


    public static boolean isPalindrome1(ListNode pHead) {
        ListNode quick = pHead;
        ListNode slow = pHead;
        Stack<Integer> stack = new Stack<>();
        while (quick.next != null && quick.next.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            quick = quick.next.next;
        }
        slow = quick.next == null ? slow.next : slow.next.next;
        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;

    }
}
