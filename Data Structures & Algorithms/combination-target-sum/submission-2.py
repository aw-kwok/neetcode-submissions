class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []

        def recurse(nums, i, total, assignment):
            if total > target:
                return
            if i >= len(nums):
                if total == target:
                    res.append(list(assignment))
                return

            assignment.append(nums[i])
            recurse(nums, i, total + nums[i], assignment)
            assignment.pop()
            recurse(nums, i + 1, total, assignment)
        
        recurse(nums, 0, 0, [])
        return res
            
            