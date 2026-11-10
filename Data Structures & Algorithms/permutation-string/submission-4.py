class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        s1_count = Counter(s1)
        s2_count = defaultdict(int)

        r = 0
        while r < len(s1):
            s2_count[s2[r]] += 1
            r += 1
        
        l = 0
        while r < len(s2):
            if s1_count == s2_count:
                return True
            s2_count[s2[l]] -= 1
            if s2_count[s2[l]] == 0:
                s2_count.pop(s2[l])
            s2_count[s2[r]] += 1
            l += 1
            r += 1
        return s1_count == s2_count