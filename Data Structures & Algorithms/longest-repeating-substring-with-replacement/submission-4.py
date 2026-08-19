class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        seen = defaultdict(int)
        res = 0
        maxF = 0
        l, r = 0, 0
        while r < len(s):
            seen[s[r]] += 1
            maxF = max(maxF, seen[s[r]])
            
            while (r - l + 1) - maxF > k:
                seen[s[l]] -= 1
                l += 1
            res = max(res, r - l + 1)
            r += 1

        return res