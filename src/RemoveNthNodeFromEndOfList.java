/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        
        if (head.next == null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0){
            fast = fast.next;
            n--;
        }
        
        while (fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if (fast == null){
            return slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
