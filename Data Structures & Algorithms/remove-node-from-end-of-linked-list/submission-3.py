# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if not head or not head.next:
            return None
        count = 0
        curr = head
        while count < n:
            curr = curr.next
            count += 1
        
        new_curr = head
        dummy = ListNode(0, new_curr)
        prev = dummy
        while curr:
            prev = new_curr
            new_curr = new_curr.next
            curr = curr.next
        prev.next = new_curr.next
        
        return dummy.next
        