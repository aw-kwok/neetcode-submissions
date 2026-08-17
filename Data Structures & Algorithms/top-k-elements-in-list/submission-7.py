class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = defaultdict(int)
        # num -> freq
        for num in nums:
            freq[num] += 1

        heap = []
        for num in freq.keys():
            heapq.heappush_max(heap, (freq[num], num))

        res = []
        for i in range(k):
            res.append(heapq.heappop_max(heap)[1])

        return res