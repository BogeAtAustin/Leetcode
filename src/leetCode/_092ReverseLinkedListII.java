package leetCode;

import leetCode.Utils.ListNode;

public class _092ReverseLinkedListII {

//    Note: 1 ≤ m ≤ n ≤ length of list.
//
//            Example:
//
//    Input: 1->2->3->4->5->NULL, m = 2, n = 4
//    Output: 1->4->3->2->5->NULL

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        if(m == n){
            return head;
        }
        ListNode fast = head, slow = head;
        while(n - 1 > 0 && fast != null){
            fast = fast.next;
            n--;
        }
        ListNode tail = fast.next;
        fast.next = null;
        ListNode beforeHead = slow;
        while(m - 1 > 0 && slow != null){
            if(m - 1 == 1){
                beforeHead = slow;
            }
            slow = slow.next;
            m--;
        }
        ListNode reverseHead = reverse(slow);
        if(slow != head){
            beforeHead.next = reverseHead;
        }else{
            head = reverseHead;
        }
        while(reverseHead.next != null){

            reverseHead = reverseHead.next;
        }
        reverseHead.next = tail;
        return head;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
