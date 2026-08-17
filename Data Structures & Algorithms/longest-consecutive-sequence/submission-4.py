class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        seen = set()
        for num in nums:
            seen.add(num)

        res = 0

        for num in nums:
            i = num
            if i - 1 in seen:
                continue
            else:
                count = 1    
                i += 1
                while i in seen:
                    count += 1
                    i += 1
                res = max(res, count)

        return res