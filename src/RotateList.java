/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0){
            return head;
        }
        //find n-th to last element
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0 && fast != null){
            fast = fast.next;
            n--;
        }
        
        if (fast == null){
            //n is bigger than list size
            //example: input {1, 2}, 3 ==> {2, 1}
            //{1, 2} rotate twice and then once, 
            //so return head with new n (after above while loop n=1)
            return rotateRight(head, n);
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        //slow is the one before new head, which is tail
        //append original head to fast
        fast.next = head;
        
        //save result
        ListNode result = slow.next;
        slow.next = null;
        
        return result;
    }
}
