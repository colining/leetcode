package cn.colining.bat.linkedlist;

/**
 * Created by colin on 2017/7/4.
 */
public class ClearValue {
    /**
     * 现在有一个单链表。链表中每个结点保存一个整数，再给定一个值val，把所有等于val的结点删掉。
     * 给定一个单链表的头结点head，同时给定一个值val，
     * 请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
     * @param args
     */
    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,3,4,3,2,1};
        int[] array2 = new int[]{2,4,6,8,10};
        ListNode head1 = new ListNode(0);
        ListNode head1Back = head1;
        ListNode head2 = new ListNode(0);
        ListNode head2Back = head2;
        for (int i = 0; i < array1.length; i++) {
            head1.next = new ListNode(array1[i]);
            head1 = head1.next;
        }

        clear(head1Back, 2);

    }

    /**
     * 主要思路，只存当前结点，和后面的结点；<br>
     * 检测后结点的是否应该被删除，若是的话，就继续向后；<br>
     * 直到找到不该被删除的结点，然后与当前结点相连<br>
     * 通过在头结点前添加结点，就不用对头结点另做判断
     * @param head
     * @param val
     * @return
     */
    public static ListNode clear(ListNode head, int val) {
        ListNode headPre = new ListNode(0);
        headPre.next = head;
        ListNode current = headPre;
        while (current != null) {
            ListNode next = current.next;
            if (next == null) {
                break;
            }
            while (next.val == val) {
                next = next.next;
            }
            current.next = next;
            current = next;
        }
        return headPre.next;
    }
}
