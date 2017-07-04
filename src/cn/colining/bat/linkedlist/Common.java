package cn.colining.bat.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;

/**
 * Created by colin on 2017/7/4.
 */
public class Common {
    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,3,4,5,6,7};
        int[] array2 = new int[]{2,4,6,8,10};
        ListNode head1 = new ListNode(0);
        ListNode head1Back = head1;
        ListNode head2 = new ListNode(0);
        ListNode head2Back = head2;
        for (int i = 0; i < array1.length; i++) {
            head1.next = new ListNode(array1[i]);
            head1 = head1.next;
        }

        for (int i = 0; i < array2.length; i++) {
            head2.next = new ListNode(array2[i]);
            head2 = head2.next;
        }

        System.out.println(Arrays.toString(findCommonParts(head1Back, head2Back)));

    }
    public static int[] findCommonParts(ListNode headA, ListNode headB) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (headA != null && headB != null) {
            if (headA.val < headB.val) {
                headA = headA.next;
            } else if (headB.val < headA.val) {
                headB = headB.next;
            }else {
                arrayList.add(headA.val);
                headA = headA.next;
            }
        }
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);

        }
        return array;
    }

}
