/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;   
        }
        
        //find mid point
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(secondHead);
        
        ListNode result = new ListNode(0);
        ListNode firstNext = first;
        ListNode secondNext = second;
        
        while (firstNext != null && secondNext != null){
            if (firstNext.val < secondNext.val){
                result.next = firstNext;
                firstNext = firstNext.next;
            } else {
                result.next = secondNext;
                secondNext = secondNext.next;
            }
            result = result.next;
        }
        
        result.next = (firstNext == null) ? secondNext : firstNext;
        
        return first.val < second.val ? first : second;
    }
}
