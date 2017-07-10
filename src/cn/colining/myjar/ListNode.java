package cn.colining.myjar;

/**
 * Created by colin on 2017/7/4.
 */

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode buildListNode(int[] array) {
        ListNode head = new ListNode(0);
        ListNode headCopy = head;
        for (int i = 0; i < array.length; i++) {
            head.next = new ListNode(array[i]);
            head = head.next;
        }
        return headCopy.next;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        buildListNode(array);
    }
}