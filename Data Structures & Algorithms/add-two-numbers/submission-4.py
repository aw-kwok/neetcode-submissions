# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head = l1
        carry = 0
        prev = None
        while l1 and l2:
            total = carry + l1.val + l2.val
            carry = total // 10
            l1.val = total % 10
            prev = l1
            l1 = l1.next
            l2 = l2.next
        
        if not l1 and not l2:
            if carry:
                prev.next = ListNode(carry, None)
            return head


        if l2:
            prev.next = l2

        curr = prev.next

        # 9 9 9 9 9 9 9
        # 9 9 9 9
        # 8 9 9 9 1

        while carry:
            total = carry + curr.val
            carry = total // 10
            curr.val = total % 10

            if curr.next:
                curr = curr.next
            else:
                if carry:
                    curr.next = ListNode(carry, None)
                return head

        return head
