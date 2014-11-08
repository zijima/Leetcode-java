/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }
        
        if (l1 == null) {
            result.next = l2;
        }
        if (l2 == null) {
            result.next = l1;
        }
        return node.next;
    }
}
