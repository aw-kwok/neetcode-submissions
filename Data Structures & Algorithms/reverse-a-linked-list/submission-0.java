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
        ListNode curr = head;
        ListNode prev = null;
        ListNode prev2 = null;
        // 1 -> 2 -> 3 -> 4 -> null
        
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            prev.next = prev2;
            prev2 = prev;
        }

        return prev;
    }
}
