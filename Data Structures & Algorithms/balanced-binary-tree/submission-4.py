# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(root):
            if not root:
                return (0, True)
            
            left_height, left_bool = dfs(root.left)
            right_height, right_bool = dfs(root.right)
            
            balanced = True if abs(left_height - right_height) <= 1 else False
            return (max(left_height, right_height) + 1, left_bool and right_bool and balanced)

        return dfs(root)[1]