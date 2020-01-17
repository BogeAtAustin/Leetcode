package leetCode;

import leetCode.Utils.ListNode;

public class _234PalindromeLinkedList {

    //这道题包括复制一个linkedlist 以及翻转linkedlist，一定要非常熟悉才行
    //S1  O(n) + O(n)
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode copyHead = new ListNode(-1);
        ListNode copyCurrent = copyHead;
        ListNode curr = head;
        while(curr != null){
            copyCurrent.next = new ListNode(curr.val);
            curr = curr.next;
            copyCurrent = copyCurrent.next;
        }
        curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            if(next == null){
                break;
            }else{
                curr = next;
            }
        }
        head = prev;

        while(head != null){
            if(copyHead.next.val != head.val){
                return false;
            }
            copyHead = copyHead.next;
            head = head.next;
        }
        return true;
    }

    //S2, reversing the second half
    //O(n) + O(1)
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
