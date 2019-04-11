package leetCode;

import leetCode.Utils.ListNode;

public class _019RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        int i = 0;
        while (i < n){
            fast = fast.next;
            i++;
        }

        if(fast == null) return head.next;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next != null){
            slow.next = slow.next.next;
        }else{
            slow.next = null;
        }
        return head;
    }
}



