/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
//TODO
public class ReorderList {
    public void reorderList(ListNode head){
        if(head == null || head.next == null) return;
        reorderList(head, head, head);
    }
        
    public ListNode reorderList(ListNode prev, ListNode slow, ListNode faster){
        if(faster == null || faster.next == null) {
            if(faster != null) {
                ListNode reverse = slow.next;
                slow.next = null;
                return reverse;
            }
            prev.next = null;
            return slow;
        }
        ListNode retNode = reorderList(slow, slow.next, faster.next.next);
        // concanate
        ListNode temp = retNode.next;
        retNode.next = slow.next;
        slow.next = retNode;
        return temp;
    }
}
