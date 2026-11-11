class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # heap (dist, point)
        heap = []
        for p in points:
            dist = -math.sqrt(p[0]**2 + p[1]**2)
            if len(heap) < k:
                heapq.heappush(heap, (dist, p))
            else:
                if heap[0][0] < dist:
                    heapq.heappop(heap)
                    heapq.heappush(heap, (dist, p))
        
        return [p[1] for p in heap]