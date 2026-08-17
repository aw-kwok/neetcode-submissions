class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        seen = set()
        for num in nums:
            seen.add(num)

        count = 0
        max_count = 0

        for num in nums:
            count = 0
            if num - 1 in nums:
                continue
            curr = num
            while curr in seen:
                count += 1
                curr += 1
            max_count = max(max_count, count)
        
        return max_count