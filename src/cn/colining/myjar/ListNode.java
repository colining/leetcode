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

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null ) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode preCopy = pre;
        //找到应该reverse的第一个结点的前一个结点
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;

        //通过每次从后往前调换位置，即可是部分逆序
        for (int i = 0; i < n-m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return preCopy.next;

    }
}