/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second= head.next;
        first.next = second.next;
        second.next = first;
        first.next = swapPairsRecursive(first.next);
        return second;
    }
    
    
    public ListNode swapPairsIterative(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null){
            return null;
        }
        
        if(head.next == null){
            return head;
        }
        ListNode re = head.next;
        ListNode node = head;
        ListNode tmp = null;
        while(node != null && node.next != null){
            if(tmp != null){
                tmp.next.next = node.next;
                
            }
            tmp = node.next;
            node.next = node.next.next;
            tmp.next = node;
            
            node = node.next;
        }
        return re;
    }
}
