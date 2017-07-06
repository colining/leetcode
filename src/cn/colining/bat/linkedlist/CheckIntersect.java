package cn.colining.bat.linkedlist;

/**
 * Created by colin on 2017/7/6.
 */
public class CheckIntersect {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node11 = new ListNode(3);
        System.out.println(chkIntersect1(node1, node11));
    }

    public static boolean chkIntersect(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return false;
        }

        int lengthA = 0;
        int lengthB = 0;
        ListNode A = headA;
        while (A != null) {
            lengthA++;
            A = A.next;
        }
        ListNode B = headB;
        while (B != null) {
            lengthB++;
            B = B.next;
        }


        if (lengthA > lengthB) {
            A = headA;
            for (int i = 0; i < lengthA - lengthB; i++) {
                A = A.next;
            }
            B = headB;
        }
        if (lengthA < lengthB) {
            B = headB;
            for (int i = 0; i < lengthB - lengthA; i++) {
                B = B.next;
            }
            A = headA;
        }
        while (A != null && B != null) {
            if (A == B) {
                return true;
            }
            A = A.next;
            B = B.next;
        }
        return false;
    }

    public static boolean chkIntersect1(ListNode headA, ListNode headB) {
        ListNode node1 = null;
        while (headA != null) {
            node1 = headA;
            headA = headA.next;
        }
        ListNode node2 = null;
        while (headB != null) {
            node2 = headB;
            headB = headB.next;
        }
        return node1 == node2;
    }

}
