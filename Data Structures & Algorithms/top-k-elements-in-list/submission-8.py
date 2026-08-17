class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = defaultdict(int)
        for num in nums:
            count[num] += 1
        
        freq = [[] for _ in range(len(nums) + 1)]

        for key, value in count.items():
            freq[value].append(key)
        
        soln = []
        for i in range(len(freq) - 1, 0, -1):
            for num in freq[i]:
                soln.append(num)
            if len(soln) == k:
                return soln
        return []