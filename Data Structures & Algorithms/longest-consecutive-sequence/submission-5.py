class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        seen = set()
        for n in nums:
            seen.add(n)
        
        res = 0
        
        for n in nums:
            if (n - 1) not in seen:
                count = 0
                curr = n
                while curr in seen:
                    curr = curr + 1
                    count += 1
                res = max(res, count)
                
        return res