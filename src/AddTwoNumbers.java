/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbersIterative(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        
        if (l1 == null){
            return l2;
        }
        
        if (l2 == null){
            return l1;
        }
        int p = 0;
        ListNode result = new ListNode(0);
        ListNode re = result;
        while(l1 != null || l2 != null){
            if (l1 != null && l2 != null){
                int n = l1.val + l2.val + p;
                p = n / 10;
                result.next = new ListNode(n % 10);
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null){
                int n = l2.val + p;
                p = n / 10;
                result.next = new ListNode(n % 10);
                l2 = l2.next;
            } else if (l2 == null){
                int n = l1.val + p;
                p = n / 10;
                result.next = new ListNode(n % 10);
                l1 = l1.next;
            }
            result = result.next;
        }
        if (p == 1){
            result.next = new ListNode(1);
        }
        
        return re.next;
    }
    
    public ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        
        if(l1 == null && l2 == null){
            return null;
        }
        int p = 0;
        ListNode result = null;
        ListNode temp = null;
        while(l1 != null && l2 != null){
            int n = p + l1.val + l2.val;
            p = n / 10;
            if(temp == null){
                temp = new ListNode(n % 10);
                result = temp;
            }else{
                temp.next = new ListNode(n % 10);
                temp = temp.next;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null){
            temp.next = (p == 0 ? l2 : addTwoNumbersRecursive(new ListNode(p), l2));
        } else {
            temp.next = (p == 0 ? l1 : addTwoNumbersRecursive(new ListNode(p), l1));
        }
        return result;
    }
}
