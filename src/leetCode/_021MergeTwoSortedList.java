package leetCode;
import leetCode.Utils.ListNode;

public class _021MergeTwoSortedList {

    //iteratively

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode fakehead = new ListNode(0);
        ListNode pivot = fakehead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                //line 15 == line 26
                pivot.next = l1;
                l1 = l1.next;

            }else{
                pivot.next = l2;
                l2 = l2.next;
            }
            pivot = pivot.next;
        }
        if(l1 != null){
            //想清楚为什么不是pivot = l1;
            pivot.next = l1;
        }
        if(l2 != null){
            pivot.next = l2;
        }
        return fakehead.next;
    }
}
