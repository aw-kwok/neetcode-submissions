# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        curr, end = head, head
        for i in range(n):
            end = end.next
        
        prev = None
        while end:
            prev = curr
            curr = curr.next
            end = end.next
        
        if curr == head:
            return head.next

        if prev:
            prev.next = curr.next
        else:
            return None

        return head