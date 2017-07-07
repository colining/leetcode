package cn.colining.bat.linkedlist;

/**
 * Created by colin on 2017/7/6.
 */
public class ChkLoop {
    /**
     * 判断单链表有环
     * @param head
     * @param adjust
     * @return
     */
    /**
     * 快慢指针
     * @param head
     * @param adjust
     * @return
     */
    public int chkLoop(ListNode head, int adjust) {
        // write code here
        if(head==null) return -1;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&& fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return -1;
        }
        fast=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow.val;
    }
}
