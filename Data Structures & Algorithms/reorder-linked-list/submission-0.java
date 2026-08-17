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
    public void reorderList(ListNode head) {
        // divide list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        // reverse list2
        ListNode prev = null;
        while (head2 != null) {
            ListNode temp = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = temp;
        }

        mergeList(head, prev);
    }
    public ListNode mergeList(ListNode head1, ListNode head2) {
        if (head2 == null) return head1;
        ListNode newHead = head1;
        head1 = head1.next;
        ListNode newHead2 = head2;
        newHead.next = newHead2;
        head2 = head2.next;
        newHead2.next = mergeList(head1, head2); 
        return newHead;
    }
}
