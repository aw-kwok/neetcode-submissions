class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        sorted_nums = sorted(nums)
        res = []
        i = 0
        print(sorted_nums)
        while i < len(nums) and sorted_nums[i] <= 0:
            if i > 0 and sorted_nums[i] == sorted_nums[i - 1]:
                i += 1
                continue
            j = i + 1
            k = len(nums) - 1
            while j < k:
                if sorted_nums[i] + sorted_nums[j] + sorted_nums[k] == 0:
                    print(i, j, k)
                    res.append([sorted_nums[i], sorted_nums[j], sorted_nums[k]])
                    j += 1
                    k -= 1
                    while j < len(nums) and sorted_nums[j] == sorted_nums[j - 1]:
                        j += 1
                elif sorted_nums[i] + sorted_nums[j] + sorted_nums[k] < 0:
                    j += 1
                else:
                    k -= 1
            i += 1
        return res