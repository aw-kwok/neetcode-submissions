class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # total chars - num_max <= k
        counts = defaultdict(int)
        num_max = 0
        res = 0

        l, r = 0, 0
        while r < len(s):
            counts[s[r]] += 1
            num_max = max(counts[s[r]], num_max)
            
            while (r - l + 1) - num_max > k:
                counts[s[l]] -= 1
                l += 1
                
            res = max(res, r - l + 1)
            r += 1
        return res
