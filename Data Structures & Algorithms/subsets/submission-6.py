class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        def backtrack(nums, i, assignment):
            nonlocal res

            if i >= len(nums):
                res.append(list(assignment))
                return

            assignment.append(nums[i])
            backtrack(nums, i + 1, assignment)
            assignment.pop()
            backtrack(nums, i + 1, assignment)
        
        backtrack(nums, 0, [])

        return res