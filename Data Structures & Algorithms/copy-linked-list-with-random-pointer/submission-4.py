"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        # old node -> new node
        node_map = {}

        curr = head
        while curr:
            node_map[curr] = Node(curr.val, None, None)
            curr = curr.next

        for n in node_map:
            new_node = node_map[n]
            new_node.next = node_map.get(n.next)
            new_node.random = node_map.get(n.random)
        
        return node_map[head]
        