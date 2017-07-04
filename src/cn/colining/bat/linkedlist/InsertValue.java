package cn.colining.bat.linkedlist;



/**
 * Created by colin on 2017/7/4.
 */
public class InsertValue {
    /**
     * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
     * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[]{1,3,4,5,7};
        int[] b = new int[]{1,2,3,4,0};
        System.out.println(insert(a, b, 2).val);
    }

    /**
     * 由于判题系统问题，这个代码完全没有可参考之处。。。。:(
     * @param array
     * @param next
     * @param val
     * @return
     */
    public static ListNode insert(int[] array, int[] next, int val) {


        if (array.length==0||array == null) {
            ListNode node = new ListNode(val);
//            node.next = node;
            return node;
        }
        ListNode head = new ListNode(array[0]);
        buildList(array, next, head);
        ListNode node = head;
        ListNode node1 = head.next;

        while (node1 != null) {
            if (node.val <= val && node1.val >= val) {
                break;
            }
            node = node1;
            node1 = node1.next;
        }
        ListNode cur = new ListNode(val);
        node.next = cur;
        cur.next = node1;

        if (val < head.val) {
            return cur;
        }
        return head;
    }

    private static void buildList(int[] array, int[] next, ListNode head) {
        ListNode node = head;
        for (int i = 0; i < array.length; i++) {
            node.next = new ListNode(array[next[i]]);
            node = node.next;
        }
    }
}
 class ListNode {
    int val;
   ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
