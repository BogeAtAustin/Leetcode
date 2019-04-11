package leetCode;

import leetCode.Utils.ListNode;

public class _61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode end = head;
        int len = 1;
        while(end.next != null){
            end = end.next;
            len++;
        }

        if(k == len) return head;

        k = k % len;
        end.next = head;
        for(int i = 0; i < len - k; i++){
            end = end.next;
        }
        head = end.next;
        end.next = null;
        return head;
    }
}
