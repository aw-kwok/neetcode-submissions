class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # num -> count
        count = Counter(nums)
        freq = [[] for i in range(len(nums) + 1)]

        for n in count:
            freq[count[n]].append(n)
        
        res = []
        i = len(nums)
        while len(res) < k:
            for n in freq[i]:
                res.append(n)
                if len(res) == k:
                    break
            i -= 1
        return res
        