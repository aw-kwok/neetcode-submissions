class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        stack = []

        def recurse(nums, i):
            nonlocal res
            nonlocal stack

            if i == len(nums):
                res.append(stack.copy())
                return
            
            stack.append(nums[i])
            recurse(nums, i + 1)
            stack.pop()
            recurse(nums, i + 1)
        
        recurse(nums, 0)
        return res