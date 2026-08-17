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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        for(int i = 0; i < n; i++) {
            curr = curr.next;
        }
        ListNode right = curr;

        curr = head;
        ListNode prev = null;
        while(right != null) {
            prev = curr;
            curr = curr.next;
            right = right.next;
        }
        if (prev == null) return curr.next;
        prev.next = curr.next;
        return head;
    }
}
