class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        count_s, count_t = defaultdict(int), defaultdict(int)
        for i, _ in enumerate(s):
            count_s[s[i]] += 1
            count_t[t[i]] += 1
        return count_s == count_t