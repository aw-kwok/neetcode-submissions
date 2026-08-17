class Solution:
    def trap(self, height: List[int]) -> int:
        i, j = 1, len(height) - 2
        max_l, max_r = height[0], height[-1]
        res = 0

        while i <= j:
            if max_l < max_r:
                res += max(0, min(max_l, max_r) - height[i])
                max_l = max(max_l, height[i])
                i += 1
            else:
                res += max(0, min(max_l, max_r) - height[j])
                max_r = max(max_r, height[j])
                j -= 1
        
        return res