package leetCode;

import leetCode.Utils.ListNode;

public class _86PartitionList {
    //看到partition, 就有点类似quick select，把小于pivot的数放到pivot前面，大于pivot的数放到pivot后面。
    //具体是前后两指针，不断的和pivot交换位置。但是这种方法不适用于链表，因为它只能从head遍历。
    //所以双指针法在这里既不是指首尾两指针，也不是指快慢指针，而是两个新的链表。
    //small链表只装小于的数，large链表只装大于的数

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode small_head = small;
        ListNode large = new ListNode(0);
        ListNode large_head = large;

        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        large.next = null;
        small.next = large_head.next;
        return small_head.next;
    }
}
