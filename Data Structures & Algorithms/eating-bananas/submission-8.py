class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # 1, max(piles)
        
        min_k = max(piles)
        l, r = 1, min_k
        
        while l <= r:
            k = (l + r) // 2
            t = self.calculateBanana(piles, k)
            if t <= h:
                min_k = k
                r = k - 1
            else:
                l = k + 1

        return min_k

    
    def calculateBanana(self, piles, k):
        total = 0

        for p in piles:
            total += math.ceil(p / k)
        
        return total