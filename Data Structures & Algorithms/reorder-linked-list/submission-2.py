# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#         s        f
#0, 1, 2, 3, 4, 5, 6

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        new_tail = slow

        prev = None
        second = slow.next

        slow.next = None

        while second:
            temp = second.next
            second.next = prev
            prev = second
            second = temp
        
        head.next = mergeList(prev, head.next)

def mergeList(list1, list2):
    if not list2:
        return list1
    if not list1:
        return list2
    list1.next = mergeList(list2, list1.next)
    return list1
        