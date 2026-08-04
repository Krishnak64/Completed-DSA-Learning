/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        int carry = 0;
        ListNode tail = new ListNode(0);
        ListNode dummy = tail;

        while(l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 == null)?0:l1.val;
            int val2 = (l2 == null)?0:l2.val;
            int val = val1 + val2 + carry;
            ListNode newNode = new ListNode(val % 10);
            carry = val / 10;

            
            tail.next = newNode;
            tail = tail.next;
            

            if(l1 != null) {
                l1 = l1.next;
            }

            if(l2 != null) {
                l2 = l2.next;
            }
        }

        return reverseList(dummy.next);
    }
}