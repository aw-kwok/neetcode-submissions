class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        sorted_nums = sorted(nums)
        
        i = 0
        while i < len(sorted_nums) - 2:
            if sorted_nums[i] > 0:
                break

            j = i + 1
            k = len(sorted_nums) - 1
            while j < k:
                if sorted_nums[i] + sorted_nums[j] + sorted_nums[k] == 0:
                    res.append([sorted_nums[i], sorted_nums[j], sorted_nums[k]])
                    j += 1
                    while j < len(sorted_nums) and sorted_nums[j - 1] == sorted_nums[j]:
                        j += 1

                    if j >= len(sorted_nums):
                        break
                    
                    k -= 1
                elif sorted_nums[i] + sorted_nums[j] + sorted_nums[k] < 0:
                    j += 1
                else:
                    k -= 1
            i += 1
            while i < len(sorted_nums) and sorted_nums[i - 1] == sorted_nums[i]:
                i += 1
        
        return res
                