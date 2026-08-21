# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def search(root, left, right):
            if not root:
                return True
            
            if root.val <= left or root.val >= right:
                return False
            
            return search(root.left, left, root.val) and search(root.right, root.val, right)
        
        return search(root, -1000000000, 1000000000)