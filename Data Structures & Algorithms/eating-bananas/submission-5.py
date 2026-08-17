class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        lo = 1
        hi = max(piles)
        res = hi
        while lo < hi:
            k = (lo + hi) // 2
            hours = calculate_time(piles, k)
            if hours > h:
                lo = k + 1
            else:
                res = min(res, k)
                hi = k
        return res

def calculate_time(piles, k):
    res = 0
    for pile in piles:
        res += math.ceil(pile / k)
    return res