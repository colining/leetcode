package cn.colining.bat.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;

import static cn.colining.myjar.Swap.swap;

/**
 * Created by colin on 2017/7/4.
 */
public class Divide {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(5);
        ListNode head = listDivide1(node, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 通过小值链表和大值链表将其拆开，最后再合并；
     * @param head
     * @param val
     * @return
     */
    public static ListNode listDivide1(ListNode head, int val) {

        ListNode small = new ListNode(0);
        ListNode headSmall = small;


        ListNode big = new ListNode(0);
        ListNode headBig = big;

        while (head != null) {
            if (head.val <= val) {
                small.next = head;
                small = head;
            }else{
                big.next = head;
                big = head;
            }
            head = head.next;
        }
        small.next = headBig.next;
        big.next = null;

        return headSmall.next;
    }

    /**
     * 通过数组来排序，但是很显然通过不了oj，<br>
     * 因为要求顺序不可更改，意思一下好嘞
     * @param head
     * @param val
     * @return
     */
    public static ListNode listDivide(ListNode head, int val) {
        ArrayList<Integer> arrayList = new ArrayList();
        ListNode node = head;
        while (node != null) {
            arrayList.add(node.val);
            node = node.next;
        }
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        sortThreeColor(array, val);
        node = head;
        for (int i = 0; i < array.length; i++) {
            node.val = array[i];
            node = node.next;
        }
        return head;
    }
    public static int[] sortThreeColor(int[] array, int val) {
        int indexOf0 = -1;                  //放0的区域，每次放入就向后扩张；
        int indexOf2 = array.length;              //放2的区域，向前扩张；
        int index = 0;
        while (index < indexOf2) {
            if (array[index] < val) {
                //小于一的话，就交换，然后继续遍历后面的
                swap(array, ++indexOf0, index++);
            } else if (array[index] > val) {
                //大于1的话，由于交换过来的是没有进行遍历过的，所以我们需要检测交换过来的数
                swap(array, --indexOf2, index);
            }
            else
                index++;
        }
        return array;
    }
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
