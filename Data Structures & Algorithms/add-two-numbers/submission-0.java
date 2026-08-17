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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;

        boolean carry = false;
        ListNode newHead = null;
        ListNode newCurr = null;
        while (l1Curr != null && l2Curr != null) {
            int val = l1Curr.val + l2Curr.val;
            if (carry) {
                val += 1;
                carry = false;
            }
            if (val > 9) {
                val -= 10;
                carry = true;
            }
            ListNode temp = new ListNode(val);
            if (newHead == null) newHead = temp;
            if (newCurr != null) newCurr.next = temp;
            newCurr = temp;
            l1Curr = l1Curr.next;
            l2Curr = l2Curr.next;
        }

        ListNode oldCurr;
        if (l1Curr == null) oldCurr = l2Curr;
        else oldCurr = l1Curr;

        while(oldCurr != null) {
            int val = oldCurr.val;
            if (carry) {
                val++;
                carry = false;
            }
            if (val > 9) {
                val -= 10;
                carry = true;
            }
            ListNode temp = new ListNode(val);
            newCurr.next = temp;
            newCurr = temp;
            oldCurr = oldCurr.next;
        }

        if (carry) newCurr.next = new ListNode(1);

        return newHead;
    }
}
