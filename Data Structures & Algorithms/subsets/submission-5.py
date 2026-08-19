class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        stack = []

        def recurse(i):
            if i == len(nums):
                res.append(stack.copy())
                return
            
            stack.append(nums[i])
            recurse(i + 1)
            stack.pop()
            recurse(i + 1)
        
        recurse(0)
        return res