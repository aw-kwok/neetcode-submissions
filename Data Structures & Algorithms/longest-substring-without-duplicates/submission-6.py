class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0 or len(s) == 1:
            return len(s)

        seen = set()
        l, r = 0, 1
        seen.add(s[l])

        res = 0
        while r < len(s):
            while s[r] in seen:
                seen.discard(s[l])
                l += 1
            seen.add(s[r])
            r += 1
            res = max(res, r - l)
        return res
            