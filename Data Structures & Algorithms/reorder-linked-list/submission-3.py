# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        prev, slow, fast = None, head, head
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        if fast:
            prev = slow
            slow = slow.next
        prev.next = None
        
        reverse_head = self.reverseList(slow)

        self.mergeList(head, reverse_head)
            

    def reverseList(self, head):
        prev = None
        curr = head
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
    
    def mergeList(self, list1, list2):
        if not list1:
            return list2
        if not list2:
            return list1
        list1.next = self.mergeList(list2, list1.next)
        return list1

        