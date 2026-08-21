# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        res = 0

        def search(node, k):
            nonlocal res

            if not node:
                return
            
            new_k = max(node.val, k)
            if node.val >= k:
                res += 1
            
            search(node.left, new_k)
            search(node.right, new_k)

        search(root, root.val)
        return res
