class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        seen = Counter(nums)
        counts = [[] for _ in range(len(nums) + 1)]
        for num, count in seen.items():
            counts[count].append(num)
        
        res = []
        i = len(counts) - 1
        while i >= 0:
            for num in counts[i]:
                res.append(num)
                if len(res) == k:
                    return res
            i -= 1
        return res