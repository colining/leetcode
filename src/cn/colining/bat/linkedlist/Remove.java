package cn.colining.bat.linkedlist;

/**
 * Created by colin on 2017/7/4.
 */
public class Remove {
    /**
     * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
     * 给定带删除的头节点和要删除的数字，请执行删除操作，返回删除后的头结点。链表中没有重复数字
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        removeNode(node, 3);
    }

    /**
     * 实际上就一句话，这道题没有完美的解法；<br>
     *
     * @param pNode
     * @param delVal
     * @return
     */
    public static ListNode removeNode(ListNode pNode, int delVal) {
        if (pNode == null) {
            return null;
        }
        if (pNode.val == delVal) {
            return pNode.next;
        }
        ListNode node = pNode;
        ListNode temp = pNode;
        while (node != null) {
            //这里就是复制后一个节点，然后删除后一个节点的做法
            if (node.val == delVal && node.next != null) {
                node.val = node.next.val;
                node.next = node.next.next;
                break;
            }
            //然而到尾节点还是不灵光的啦，一定需要前节点
            else if (node.val == delVal && node.next == null) {
                temp.next = null;
                break;
            }
            temp = node;
            node = node.next;

        }
        return pNode;
    }
}
