class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = [-1 * s for s in stones]
        heapq.heapify(heap)

        while len(heap) > 1:
            a, b = heapq.heappop(heap), heapq.heappop(heap)
            if a == b:
                continue
            else:
                heapq.heappush(heap, -1 * abs(a - b))
        
        return -1 * heap[0] if heap else 0