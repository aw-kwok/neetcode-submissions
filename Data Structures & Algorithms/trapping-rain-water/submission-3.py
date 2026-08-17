class Solution:
    def trap(self, height: List[int]) -> int:
        pref = [0] * len(height)
        pref[0] = height[0]
        for i in range(1, len(height)):
            pref[i] = max(pref[i - 1], height[i])

        suff = [0] * len(height)
        suff[len(height) - 1] = height[len(height) - 1]
        for i in range(len(height) - 2, -1, -1):
            suff[i] = max(suff[i + 1], height[i])

        res = 0
        for i in range(len(height)):
            res += max(0, min(pref[i], suff[i]) - height[i])
        return res