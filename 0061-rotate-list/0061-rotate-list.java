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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        int size = 0;

        while(temp != null) {
            size++;
            temp = temp.next;
        }

        temp = head;
        int n = k % size;

        if(n == 0) {
            return head;
        }
        int count = size - n;

        for(int i=1; i<count; i++) {
            temp = temp.next;
        }

        ListNode sec = temp.next;
        ListNode tail = sec;

        temp.next = null;
        while(tail.next != null) {
            tail = tail.next;
        }

        tail.next = head;
        head = sec;

        return head;
    }
}